package io.github.jcampbell7472.ggst_stats.bot;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.github.jcampbell7472.ggst_stats.client.ApiClient;
import io.github.jcampbell7472.ggst_stats.dto.player.PlayerDTO;
import io.github.jcampbell7472.ggst_stats.dto.player.RatingDTO;
import io.github.jcampbell7472.ggst_stats.dto.search.SearchPlayerDTO;
import io.github.jcampbell7472.ggst_stats.dto.search.SearchPlayerListDTO;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.utils.FileUpload;

@Component
public class SlashCommandListener extends ListenerAdapter {

    private ApiClient apiClient;
    private final Map<String, PlayerSession> sessions = new HashMap<>();

    public SlashCommandListener(ApiClient apiClient) {
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

        PlayerSession session = new PlayerSession(player);

        EmbedBuilder embed = buildEmbed(session);

        event.replyEmbeds(embed.build())
                .addFiles(
                        characterFile(session.getCurrentRating().getCharShort()),
                        rankFile(session.getCurrentRating().getTopRating().getRank()))
                .addActionRow(
                        Button.primary("prev", "⬅️"),
                        Button.primary("next", "➡️"))
                .queue(hook -> {
                    hook.retrieveOriginal().queue(message -> {
                        sessions.put(message.getId(), session);
                    });
                });
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        PlayerSession session = sessions.get(event.getMessageId());

        if (session == null)
            return;

        if (event.getButton().getId().equals("next")) {
            session.next();
        } else if (event.getButton().getId().equals("prev")) {
            session.prev();
        }

        EmbedBuilder embed = buildEmbed(session);

        RatingDTO rating = session.getCurrentRating();

        event.editMessageEmbeds(embed.build())
                .setFiles(
                        characterFile(rating.getCharShort()),
                        rankFile(rating.getTopRating().getRank()))
                .queue();
    }

    private EmbedBuilder buildEmbed(PlayerSession session) {
        PlayerDTO player = session.getPlayer();
        RatingDTO rating = session.getCurrentRating();

        EmbedBuilder embed = new EmbedBuilder();

        embed.setTitle(player.getName() + " — " + rating.getCharacter());
        embed.setDescription("Character " + (session.getIndex() + 1) +
                "/" + player.getRatings().size());

        embed.addField("Rank", rating.getTopRating().getRank(), true);
        embed.addField("Rating", String.valueOf(rating.getRating()), true);
        embed.addField("Matches", String.valueOf(rating.getMatchCount()), true);

        embed.setThumbnail("attachment://rank.png");
        embed.setImage("attachment://character.png");

        embed.setColor(getRankColor(rating.getTopRating().getRank()));
        embed.setFooter("GGST Stats");

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

    private FileUpload rankFile(String rank) {
        String fileName = rank == null ? "unknown.png" : rank.toLowerCase().replace(" ", "") + ".png";
        String path = "/images/ranks/" + fileName;
        return FileUpload.fromData(
                getClass().getResourceAsStream(path),
                "rank.png");
    }

    private FileUpload characterFile(String shortCode) {
        String fileName = getCharacterFile(shortCode); // only filename
        String path = "/images/characters/" + fileName; // add folder here
        return FileUpload.fromData(
                getClass().getResourceAsStream(path),
                "character.png");
    }

    private String getCharacterFile(String charShort) {
        if (charShort == null)
            return "unknown.png";

        return switch (charShort) {
            case "AN" -> "anji.png";
            case "AX" -> "axl.png";
            case "LE" -> "leo.png";
            case "MI" -> "millia.png";
            case "GO" -> "goldlewis.png";
            case "BE" -> "bedman.png";
            case "SL" -> "slayer.png";
            case "SI" -> "sin.png";
            case "TE" -> "testament.png";
            case "UN" -> "unika.png";
            case "CH" -> "chipp.png";
            case "ZA" -> "zato.png";
            case "PO" -> "potemkin.png";
            case "EL" -> "elphelt.png";
            case "BA" -> "baiken.png";
            case "LU" -> "lucy.png";
            case "AB" -> "aba.png";
            case "JN" -> "johnny.png";
            case "IN" -> "ino.png";
            case "NA" -> "nagoriyuki.png";
            case "KY" -> "ky.png";
            case "HA" -> "happychaos.png";
            case "MA" -> "may.png";
            case "JC" -> "jacko.png";
            case "SO" -> "sol.png";
            case "DI" -> "dizzy.png";
            case "FA" -> "faust.png";
            case "RA" -> "ramlethal.png";
            case "AS" -> "asuka.png";
            case "GI" -> "giovanna.png";
            case "VE" -> "venom.png";
            case "BI" -> "bridget.png";
            default -> "unknown.png";
        };
    }
}