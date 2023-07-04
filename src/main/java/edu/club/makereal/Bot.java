package edu.club.makereal;

import edu.club.makereal.event_listener.CmdLineListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.ArrayList;

public class Bot {

    public static void main(String[] args) {
        ArrayList<GatewayIntent> intents = new ArrayList<>();
        intents.add(GatewayIntent.MESSAGE_CONTENT); // privileged
        intents.add(GatewayIntent.GUILD_MESSAGES);

        JDA jda = JDABuilder.createDefault(args[0], intents)
                            .addEventListeners(new CmdLineListener())
                            .build();
    }

}
