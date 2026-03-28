package io.github.jcampbell7472.ggst_stats.bot;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;

@Component
public class AssetManager extends ListenerAdapter {

    public static final Map<String, String> CHARACTER_URLS = new HashMap<>();
    public static final Map<String, String> RANK_URLS = new HashMap<>();

    private static final long ASSET_CHANNEL_ID = 1487399812650238094L; // your channel id

    @Override
    public void onReady(ReadyEvent event) {
        TextChannel channel = event.getJDA().getTextChannelById(ASSET_CHANNEL_ID);

        uploadCharacters(channel);
        uploadRanks(channel);
    }

    private void uploadCharacters(TextChannel channel) {
        String[] characters = CHARACTER_FILES;

        for (String c : characters) {
            InputStream is = getClass().getResourceAsStream("/images/characters/" + c);

            if(is==null){
                System.out.println("Character file not found:"+c);
                return;
            }

            channel.sendFiles(FileUpload.fromData(is, c + ".png"))
                    .queue(msg -> {
                        String url = msg.getAttachments().get(0).getUrl();
                        CHARACTER_URLS.put(c, url);
                        System.out.println("Stored character URL: " + c + "URL: " + url);
                    });
        }
    }

    private void uploadRanks(TextChannel channel) {
        String[] ranks = RANK_FILES;

        for (String r : ranks) {
            InputStream is = getClass().getResourceAsStream("/images/ranks/" + r);

            if(is==null){
                System.out.println("Rank file not found:"+r);
                return;
            }

            channel.sendFiles(FileUpload.fromData(is, r + ".png"))
                    .queue(msg -> {
                        String url = msg.getAttachments().get(0).getUrl();
                        RANK_URLS.put(r, url);
                        System.out.println("Stored rank URL: " + r+ "URL: " + url);
                    });
        }

    }

   private static final String[] CHARACTER_FILES = {
    "anji.png",
    "axl.png",
    "leo.png",
    "millia.png",
    "goldlewis.png",
    "bedman.png",
    "slayer.png",
    "sin.png",
    "testament.png",
    "unika.png",
    "chipp.png",
    "zato.png",
    "potemkin.png",
    "elphelt.png",
    "baiken.png",
    "lucy.png",
    "aba.png",
    "johnny.png",
    "ino.png",
    "nagoriyuki.png",
    "ky.png",
    "happychaos.png",
    "may.png",
    "jacko.png",
    "sol.png",
    "dizzy.png",
    "faust.png",
    "ramlethal.png",
    "asuka.png",
    "giovanna.png",
    "venom.png",
    "bridget.png"
};

private static final String[] RANK_FILES = {
    "placement.png",

    "iron1.png",
    "iron2.png",
    "iron3.png",

    "bronze1.png",
    "bronze2.png",
    "bronze3.png",

    "silver1.png",
    "silver2.png",
    "silver3.png",

    "gold1.png",
    "gold2.png",
    "gold3.png",

    "platinum1.png",
    "platinum2.png",
    "platinum3.png",

    "diamond1.png",
    "diamond2.png",
    "diamond3.png",

    "vanquisher.png"
};
}
