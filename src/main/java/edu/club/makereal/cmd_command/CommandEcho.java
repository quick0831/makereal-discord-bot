package edu.club.makereal.cmd_command;

import edu.club.makereal.CmdCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.concurrent.CompletableFuture;

public class CommandEcho implements CmdCommand {
    @Override
    public CompletableFuture<Integer> run(String[] args, MessageReceivedEvent event) {
        return CompletableFuture
                .supplyAsync(() -> event.getMessage().getContentRaw().split("[ \t\n\r]+")[1])
                .thenApplyAsync(msg -> event.getChannel().sendMessage(msg).submit())
                .handle((result, exception) -> {
                    if (exception == null) {
                        return 0;
                    } else {
                        return 1;
                    }
                });
    }
}
