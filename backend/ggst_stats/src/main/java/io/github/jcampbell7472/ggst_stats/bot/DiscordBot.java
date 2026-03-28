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
    private final SlashCommandListener slashListener;
    private final AssetManager assetManager; //only used to upload images initially

    //bot token set in application-local.properties
    @Value("${discord.token}")
    private String token;

    public DiscordBot(SlashCommandListener slashListener, AssetManager assetManager) {
        this.slashListener = slashListener; //inject listeners
        this.assetManager = assetManager;
    }

    //starts the bot
    public void start() throws Exception {
        //start up JDA instance
        JDA jda = JDABuilder.createDefault(token)
                .addEventListeners(slashListener) //add assetManager too if needed
                .build();

        jda.awaitReady();

        // Register slash command
        jda.updateCommands().addCommands(
                Commands.slash("player", "Get player stats")
                        .addOption(OptionType.STRING, "name", "Player name", true)
        ).queue();
    }
}