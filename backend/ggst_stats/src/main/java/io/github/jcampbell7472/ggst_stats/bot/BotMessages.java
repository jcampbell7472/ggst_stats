package io.github.jcampbell7472.ggst_stats.bot;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.interactions.InteractionHook;

public final class BotMessages {

    private BotMessages() {}

    public static void sendError(InteractionHook hook, String message) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Error")
                .setDescription(message)
                .setColor(Color.RED);

        hook.sendMessageEmbeds(embed.build())
            .setEphemeral(false)
            .queue();
    }
}