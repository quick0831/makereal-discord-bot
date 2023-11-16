package edu.club.makereal.cmd_command;

import edu.club.makereal.CmdCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.javatuples.Pair;

import java.util.concurrent.CompletableFuture;

public class CommandEcho implements CmdCommand {
    static final String help_msg = "usage: `echo <message>`";

    @Override
    public CompletableFuture<Integer> run(String[] args, MessageReceivedEvent event) {
        return CompletableFuture
                .supplyAsync(() -> event.getMessage().getContentRaw().split("[ \t\n\r]+", 2)[1])
                .handleAsync((result, exception) -> {
                    if (exception == null) {
                        return new Pair<>(result, 0);
                    } else {
                        return new Pair<>(help_msg, 1);
                    }
                })
                .thenCompose(result -> event.getChannel().sendMessage(result.getValue0()).submit()
                                            .thenApply(r -> new Pair<>(r, result.getValue1())))
                .handle((result, exception) -> {
                    if (exception == null) {
                        return result.getValue1();
                    } else {
                        return 2;
                    }
                });
    }
}
