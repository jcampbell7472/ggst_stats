package io.github.jcampbell7472.ggst_stats.dto.player;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatingDTO {

    private Float rating; //the player's rating with a character
    @JsonProperty("char_short")
    private String charShort; //a shortform of the character's name, e.g. "UN"
    private String character; //full name of the character
    @JsonProperty("match_count") 
    private Integer matchCount; //total matches played with the character
    @JsonProperty("top_char")
    private Integer topChar; //rank for character, e.g. #200
    @JsonProperty("top_rating")
    private TopRatingDTO topRating; //the player's top rating as an object, has rating and timestamp
    private String rank;
    
    public RatingDTO(){}

    @JsonSetter("rating")
    public void setRating(Float rating) {
        this.rating = rating;
        if (checkVanquisher(rating)) {
            this.rating = rating % 1_000_000;
            this.rank = "Vanquisher";
        } else {
            this.rank = checkRank(this.rating);
        }
    }

     // method to check that the rating is vanquisher or not
    public boolean checkVanquisher(Float rating) {
        return rating != null && rating > 1_000_000;
    }

    private String checkRank(Float rating) {
        if (rating == null)
            return "Unknown";

        if (rating >= 40800)
            return "Diamond 3";
        else if (rating >= 36600)
            return "Diamond 2";
        else if (rating >= 32400)
            return "Diamond 1";

        else if (rating >= 28400)
            return "Platinum 3";
        else if (rating >= 24400)
            return "Platinum 2";
        else if (rating >= 20400)
            return "Platinum 1";

        else if (rating >= 18000)
            return "Gold 3";
        else if (rating >= 15600)
            return "Gold 2";
        else if (rating >= 13200)
            return "Gold 1";

        else if (rating >= 11000)
            return "Silver 3";
        else if (rating >= 8800)
            return "Silver 2";
        else if (rating >= 6600)
            return "Silver 1";

        else if (rating >= 5400)
            return "Bronze 3";
        else if (rating >= 4200)
            return "Bronze 2";
        else if (rating >= 3000)
            return "Bronze 1";

        else if (rating >= 2000)
            return "Iron 3";
        else if (rating >= 1000)
            return "Iron 2";
        else if (rating >= 1)
            return "Iron 1";

        return "Unknown";
    }

    public Float getRating() {
        return rating;
    }

    public String getCharShort() {
        return charShort;
    }

    public String getCharacter() {
        return character;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getTopChar() {
        return topChar;
    }

    public TopRatingDTO getTopRating() {
        return topRating;
    }

    public String getRank(){
        return rank;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RatingDTO{");
        sb.append("rating=").append(rating);
        sb.append(", charShort=").append(charShort);
        sb.append(", character=").append(character);
        sb.append(", matchCount=").append(matchCount);
        sb.append(", topChar=").append(topChar);
        sb.append(", topRating=").append(topRating);
        sb.append(", rank=").append(rank);
        sb.append('}');
        return sb.toString();
    }

    
}
