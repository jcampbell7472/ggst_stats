package io.github.jcampbell7472.ggst_stats.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

@Component
public class DiscordBot {

        @Value("${discord.token}")
        private String token;

        public void start() throws Exception {
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