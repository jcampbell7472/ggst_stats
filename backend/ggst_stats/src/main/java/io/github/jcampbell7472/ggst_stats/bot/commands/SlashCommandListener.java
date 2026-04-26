package io.github.jcampbell7472.ggst_stats.bot.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class SlashCommandListener extends ListenerAdapter {

    //map of all SlashCommands, collected by Spring. Key taken from SlashCommand.getName
    private final Map<String, SlashCommand> commands = new HashMap<>();

    //injects all SlashCommands into commands map
    public SlashCommandListener(List<SlashCommand> commandList) {
        for (SlashCommand cmd : commandList) {
            commands.put(cmd.getName(), cmd);
        }
    }

    //called every time a slash command is used
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        System.out.println("Slash command invoked by "+ event.getUser().getName());
        SlashCommand cmd = commands.get(event.getName()); //get the command from commands map corresponding to the name of the event
        if (cmd != null) {
            cmd.handleSlash(event); //call handleSlash of that command, passing the event
        }
    }

    //called when a button interaction is used
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        System.out.println("Button used by "+ event.getUser().getName());
        String id = event.getButton().getId(); //get the id of the button as a String

        if (id == null || !id.contains(":")) //check that the button is not null and contains ":"
            return;

        String commandName = id.split(":")[0]; //get the buttons SlashCommand name, e.g. "player:prev" will be "player"

        SlashCommand cmd = commands.get(commandName); //get the corresponding SlashCommand from the commands map
        if (cmd != null) {
            cmd.handleButton(event); //call handleButton of that command
        }
    }
}