/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.jcampbell7472.ggst_stats.dto.player;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 *
 * @author jake
 */
public class TopRatingDTO {

    private String timestamp;
    private Float value;
    private String rank;

    public TopRatingDTO() {
    }

    @JsonSetter("timestamp")
    public void setTimestamp(String timestamp) {
        int spaceIndex = timestamp.indexOf(' ');

        String result;
        if (spaceIndex != -1) {
            result = timestamp.substring(0, spaceIndex); // everything before the first space
        } else {
            result = timestamp; // no space, keep the whole string
        }
        this.timestamp = result;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Float getValue() {
        return value;
    }

    public String getRank() {
        return rank;
    }

    @JsonSetter("value")
    public void setValue(Float value) {
        this.value = value;
        if(value != null && value > 1_000_000){
            this.value = value % 1_000_000;
            if(this.value<1600){
                this.rank = "Vanquisher";
            }
            else if(this.value<1700){
                this.rank = "Vanquisher I Ignis";
            }
            else if(this.value<1800){
                this.rank = "Vanquisher II Virtus";
            }
            else if(this.value<1900){
                this.rank = "Vanquisher III Vindex";
            }
            else{
                this.rank = "Vanquisher III Vindex";
            }
        }
        else{
            this.rank = checkRank(value);
        }
    }


    private String checkRank(Float value) {
        if (value == null)
            return "Placement";

        if (value >= 40800)
            return "Diamond 3";
        else if (value >= 36600)
            return "Diamond 2";
        else if (value >= 32400)
            return "Diamond 1";

        else if (value >= 28400)
            return "Platinum 3";
        else if (value >= 24400)
            return "Platinum 2";
        else if (value >= 20400)
            return "Platinum 1";

        else if (value >= 18000)
            return "Gold 3";
        else if (value >= 15600)
            return "Gold 2";
        else if (value >= 13200)
            return "Gold 1";

        else if (value >= 11000)
            return "Silver 3";
        else if (value >= 8800)
            return "Silver 2";
        else if (value >= 6600)
            return "Silver 1";

        else if (value >= 5400)
            return "Bronze 3";
        else if (value >= 4200)
            return "Bronze 2";
        else if (value >= 3000)
            return "Bronze 1";

        else if (value >= 2000)
            return "Iron 3";
        else if (value >= 1000)
            return "Iron 2";
        else if (value >= 1)
            return "Iron 1";

        return "Placement";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopRatingDTO{");
        sb.append("timestamp=").append(timestamp);
        sb.append(", value=").append(value);
        sb.append(", rank=").append(rank);
        sb.append('}');
        return sb.toString();
    }

}
