package edu.club.makereal.event_listener;

import edu.club.makereal.CmdCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Map;

public class CmdLineListener extends ListenerAdapter {

    final Map<String, CmdCommand> cmd;

    public CmdLineListener(Map<String, CmdCommand> m) {
        cmd = m;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor() == event.getJDA().getSelfUser())
            return;
        if (!event.getChannel().getId().equals("1125760703916163142"))
            return;
        String msg = event.getMessage().getContentRaw();

        if (msg.equals(""))
            return;

        String[] args = msg.split("[ \t\n\r]+");

        if (args.length == 0)
            return;

        CmdCommand c = cmd.get(args[0]);
        if (c == null) {
            event.getChannel().sendMessage(String.format("Unknown command `%s`", args[0])).queue();
            return;
        }

        c.run(args, event)
         .handle((result, exception) -> ((exception == null) ? result : 100))
         .whenCompleteAsync((result, exception) -> {
             if (result != 0) {
                 event.getChannel().sendMessage(String.format("Command failed with code `%d`", result)).queue();
             }
         });
    }
}
