package io.github.jcampbell7472.ggst_stats.bot.commands;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import io.github.jcampbell7472.ggst_stats.bot.AssetUrls;
import io.github.jcampbell7472.ggst_stats.client.ApiClient;
import io.github.jcampbell7472.ggst_stats.dto.player.PlayerDTO;
import io.github.jcampbell7472.ggst_stats.dto.player.RatingDTO;
import io.github.jcampbell7472.ggst_stats.dto.search.SearchPlayerDTO;
import io.github.jcampbell7472.ggst_stats.dto.search.SearchPlayerListDTO;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

@Component
public class SlashPlayer implements SlashCommand {

    private final ApiClient apiClient; // instantiate ApiClient
    private final Cache<String, PlayerSession> sessions = Caffeine.newBuilder()// cache to store a PlayerSession(stores player, index, total ratings)
        .expireAfterAccess(5, TimeUnit.MINUTES)
        .maximumSize(500)
        .build();

    public SlashPlayer(ApiClient apiClient) {
        this.apiClient = apiClient; // ApiClient is injected
    }

    // this method is needed in SlashCommandListener to map SlashCommands
    @Override
    public String getName() {
        return "player";
    }

    // method called when /player command is used
    @Override
    public void handleSlash(SlashCommandInteractionEvent event) {
        event.deferReply().queue();

        String name = event.getOption("name").getAsString(); // get the user input

        SearchPlayerListDTO playerList = apiClient.searchPlayers(name); // search for the name that the user inputted

        // check if the name exists
        if (playerList == null || playerList.getResults() == null || playerList.getResults().isEmpty()) {
            event.reply("Player not found").queue();
            return;
        }

        SearchPlayerDTO search = playerList.getResults().get(0); // get the first result from the search
        PlayerDTO player = apiClient.getPlayerData(search.getId()); // use the player's id to get their player data

        PlayerSession session = new PlayerSession(player);

        EmbedBuilder embed = buildEmbed(session);

        event.getHook().sendMessageEmbeds(embed.build())
                .addActionRow(
                        Button.primary("player:prev", "⬅️"),
                        Button.primary("player:next", "➡️"))
                .queue(message -> {
                    sessions.put(message.getId(), session);
                });
    };

    @Override
    public void handleButton(ButtonInteractionEvent event) {
        PlayerSession session = sessions.getIfPresent(event.getMessageId());

        if (session == null)
            return;

        if (event.getButton().getId().equals("player:next")) {
            session.next();
        } else if (event.getButton().getId().equals("player:prev")) {
            session.prev();
        }

        EmbedBuilder embed = buildEmbed(session);

        RatingDTO rating = session.getCurrentRating();

        event.editMessageEmbeds(embed.build())
                .queue();
    }

    private EmbedBuilder buildEmbed(PlayerSession session) {
        PlayerDTO player = session.getPlayer();
        RatingDTO rating = session.getCurrentRating();

        EmbedBuilder embed = new EmbedBuilder();

        embed.setTitle(player.getName() + " — " + rating.getCharacter());
        embed.setDescription("Character " + (session.getIndex() + 1) +
                "/" + player.getRatings().size());

        embed.addField("Rank", rating.getRank(), true);
        embed.addField("Rating", String.valueOf(Math.round(rating.getRating())), true);
        embed.addField("Matches", String.valueOf(rating.getMatchCount()), true);

        embed.addField("Top Rating", String.valueOf(Math.round(rating.getTopRating().getValue())) + " - "
                + rating.getTopRating().getTimestamp(), false);

        embed.setThumbnail(AssetUrls.RANK_URLS.get(rating.getRank()));
        embed.setImage(AssetUrls.CHARACTER_URLS.get(rating.getCharShort()));

        embed.setColor(getRankColor(rating.getRank()));
        embed.setFooter("Data provided by puddle.farm API");

        return embed;
    }

    private Color getRankColor(String rank) {
        if (rank == null)
            return Color.GRAY;

        if (rank.contains("Diamond"))
            return Color.CYAN;
        if (rank.contains("Platinum"))
            return Color.GREEN;
        if (rank.contains("Gold"))
            return Color.YELLOW;
        if (rank.contains("Silver"))
            return Color.LIGHT_GRAY;
        if (rank.contains("Bronze"))
            return new Color(205, 127, 50);
        if (rank.contains("Iron"))
            return Color.DARK_GRAY;
        if (rank.contains("Vanquisher"))
            return Color.MAGENTA;

        return Color.WHITE;
    }


}
