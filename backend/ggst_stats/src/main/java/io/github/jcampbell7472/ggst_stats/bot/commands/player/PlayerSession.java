package io.github.jcampbell7472.ggst_stats.bot.commands.player;

import io.github.jcampbell7472.ggst_stats.dto.player.PlayerDTO;
import io.github.jcampbell7472.ggst_stats.dto.player.RatingDTO;

public class PlayerSession {
    private final PlayerDTO player;
    private int index;
    private final int totalRatings;

    public PlayerSession(PlayerDTO player) {
        this.player = player;
        this.index = 0;
        this.totalRatings = player.getRatings().size();
    }

    public RatingDTO getCurrentRating() {
        return player.getRatings().get(index);
    }

    public void next() {
        if(index==totalRatings-1){
            index=0;
        }else{
            index++;
        }
    }

    public void prev() {
        if(index==0){
            index=totalRatings-1;
        }else{
            index--;
        }
    }

    public int getIndex() {
        return index;
    }

    public PlayerDTO getPlayer() {
        return player;
    }
}