package io.github.jcampbell7472.ggst_stats.bot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.github.jcampbell7472.ggst_stats.bot.commands.SlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class SlashCommandListener extends ListenerAdapter {

    private final Map<String, SlashCommand> commands = new HashMap<>();

    public SlashCommandListener(List<SlashCommand> commandList) {
        for (SlashCommand cmd : commandList) {
            commands.put(cmd.getName(), cmd);
        }
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        SlashCommand cmd = commands.get(event.getName());
        if (cmd != null) {
            cmd.handleSlash(event);
        }
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        for (SlashCommand cmd : commands.values()) {
            cmd.handleButton(event);
        }
    }
}