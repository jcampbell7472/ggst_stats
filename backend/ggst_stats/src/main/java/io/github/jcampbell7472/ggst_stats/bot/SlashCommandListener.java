package io.github.jcampbell7472.ggst_stats.bot;

import org.springframework.stereotype.Component;

import io.github.jcampbell7472.ggst_stats.client.ApiClient;
import io.github.jcampbell7472.ggst_stats.dto.player.PlayerDTO;
import io.github.jcampbell7472.ggst_stats.dto.search.SearchPlayerDTO;
import io.github.jcampbell7472.ggst_stats.dto.search.SearchPlayerListDTO;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class SlashCommandListener extends ListenerAdapter {

    private ApiClient apiClient;

    public SlashCommandListener(ApiClient apiClient){
        this.apiClient = apiClient;
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (!event.getName().equals("player"))
            return;

        String name = event.getOption("name").getAsString();

        SearchPlayerListDTO playerList = apiClient.searchPlayers(name);

        if (playerList == null || playerList.getResults() == null || playerList.getResults().isEmpty()) {
            event.reply("Player not found").queue();
            return;
        }

        SearchPlayerDTO search = playerList.getResults().get(0);
        PlayerDTO player = apiClient.getPlayerData(search.getId());

        event.reply(
                player.toString())
                .queue();
    }
}