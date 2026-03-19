package io.github.jcampbell7472.ggst_stats.dto.player;


import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatingDTO {

    private int rating;
    private int deviation;
    private String char_short;
    private String character;
    private int match_count;
    private int top_char;
    
    @Autowired
    public RatingDTO(int rating, int deviation, String char_short, String character, int match_count, int top_char) {
        this.rating = rating;
        this.deviation = deviation;
        this.char_short = char_short;
        this.character = character;
        this.match_count = match_count;
        this.top_char = top_char;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlayerRating{");
        sb.append("rating=").append(rating);
        sb.append(", deviation=").append(deviation);
        sb.append(", char_short=").append(char_short);
        sb.append(", character=").append(character);
        sb.append(", match_count=").append(match_count);
        sb.append(", top_char=").append(top_char);
        sb.append('}');
        return sb.toString();
    }

    
}
