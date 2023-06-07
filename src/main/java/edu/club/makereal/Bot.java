package edu.club.makereal;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Bot {

    public static void main(String[] args) {
        JDA jda = JDABuilder.createDefault(args[0])
        //        .disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE)
        //        .setBulkDeleteSplittingEnabled(false)
        //        .setActivity(Activity.watching("TV"))
                .build();
    }

}
