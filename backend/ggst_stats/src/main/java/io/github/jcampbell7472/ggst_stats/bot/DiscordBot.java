package io.github.jcampbell7472.ggst_stats.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class DiscordBot {

    public static void start() throws Exception {
        String token = System.getenv("DISCORD_TOKEN");

        JDA jda = JDABuilder.createDefault(token)
                .addEventListeners(new SlashCommandListener())
                .build();

        jda.awaitReady();

        // register command
        jda.updateCommands().addCommands(
                Commands.slash("player", "Get player stats")
                        .addOption(OptionType.STRING, "name", "Player name", true))
                .queue();

    }
}