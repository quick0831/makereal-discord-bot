package edu.club.makereal;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.concurrent.CompletableFuture;

public interface CmdCommand {
    // Return 0 to indicate success
    CompletableFuture<Integer> run(final String[] args, MessageReceivedEvent event);
}
