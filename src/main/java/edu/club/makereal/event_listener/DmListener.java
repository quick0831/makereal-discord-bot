package edu.club.makereal.event_listener;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DmListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User author = event.getAuthor();
        JDA jda = event.getJDA();
        if (author == jda.getSelfUser())
            return;
        String author_id = author.getId();
        if (!author_id.equals("529621208434606081"))
            return;

        Message msg = event.getMessage();
        if (!msg.isFromType(ChannelType.PRIVATE))
            return;

        String content = msg.getContentRaw();

        if (content.equals(""))
            return;

        TextChannel ch = jda.getTextChannelById("1099635564715720766");
        if (ch == null)
            return;
        ch.sendMessage(content).queue();
    }
}
