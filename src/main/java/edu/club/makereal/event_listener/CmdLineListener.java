package edu.club.makereal.event_listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CmdLineListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor() == event.getJDA().getSelfUser())
            return;
        if (!event.getChannel().getId().equals("1125760703916163142"))
            return;
        String msg = event.getMessage().getContentRaw();
        event.getChannel().sendMessage(msg).submit();
    }
}
