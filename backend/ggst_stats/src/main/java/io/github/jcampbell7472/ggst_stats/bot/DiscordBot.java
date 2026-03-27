package io.github.jcampbell7472.ggst_stats.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

@Component
public class DiscordBot {

    //instantiate SlashCommandListener needed for bot's slash commands
    private final SlashCommandListener listener;

    //bot token set in application-local.properties
    @Value("${discord.token}")
    private String token;

    public DiscordBot(SlashCommandListener listener) {
        this.listener = listener; //inject listener
    }

    //starts the bot
    public void start() throws Exception {
        //start up JDA instance
        JDA jda = JDABuilder.createDefault(token)
                .addEventListeners(listener)
                .build();

        jda.awaitReady();

        // Register slash command
        jda.updateCommands().addCommands(
                Commands.slash("player", "Get player stats")
                        .addOption(OptionType.STRING, "name", "Player name", true)
        ).queue();
    }
}