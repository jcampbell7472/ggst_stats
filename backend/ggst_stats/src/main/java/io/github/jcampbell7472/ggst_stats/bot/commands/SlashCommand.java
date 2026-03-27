package io.github.jcampbell7472.ggst_stats.bot.commands;


import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

//interface for all SlashCommands
public interface SlashCommand {

    String getName();

    void handleSlash(SlashCommandInteractionEvent event);

    void handleButton(ButtonInteractionEvent event);
}
