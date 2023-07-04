package edu.club.makereal.event_listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class CmdLineListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor() == event.getJDA().getSelfUser())
            return;
        if (!event.getChannel().getId().equals("1125760703916163142"))
            return;
        String msg = event.getMessage().getContentRaw();
        event.getChannel().sendMessage(msg).submit();

        String[] args = msg.split(" ");

        if (args.length >= 2 && Objects.equals(args[0], "echo")) {
            event.getJDA().getTextChannelById("1070643978438987786")
                 .sendMessage(msg.split(" ", 2)[1]).submit();
        }
    }
}
