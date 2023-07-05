package edu.club.makereal;

import edu.club.makereal.cmd_command.CommandEcho;
import edu.club.makereal.event_listener.CmdLineListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class Bot {

    public static void main(String[] args) {
        ArrayList<GatewayIntent> intents = new ArrayList<>();
        intents.add(GatewayIntent.MESSAGE_CONTENT); // privileged
        intents.add(GatewayIntent.GUILD_MESSAGES);

        HashMap<String, CmdCommand> cmd = new HashMap<>();

        cmd.put("echo", new CommandEcho());
        cmd.put("sleep", (args_, event) -> CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {
                        return 2;
                    }
                    return 0;
                })
                .thenApplyAsync(res -> event.getChannel().sendMessage("sleep 1 second").submit())
                .handle((result, exception) -> (exception == null) ? 0 : 1)
        );

        JDABuilder.createDefault(args[0], intents)
                  .addEventListeners(new CmdLineListener(cmd))
                  .build();
    }

}
