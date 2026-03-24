package io.github.jcampbell7472.ggst_stats.dto.player;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerDTO {

    private Long id;
    private String name;
    private List<RatingDTO> ratings;
    private String platform;
    @JsonProperty("top_global")
    private Integer topGlobal;

    public PlayerDTO() {
    }

    public void setRatings(List<RatingDTO> ratings) {
        this.ratings = ratings;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<RatingDTO> getRatings() {
        return ratings;
    }

    public String getPlatform() {
        return platform;
    }

    public Integer getTopGlobal() {
        return topGlobal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== PLAYER ===\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Platform: ").append(platform).append("\n");
        sb.append("Top Global: ").append(topGlobal).append("\n");

        sb.append("\n--- Ratings ---\n");
        if (ratings != null && !ratings.isEmpty()) {
            for (RatingDTO r : ratings) {
                sb.append(r).append("\n");
            }
        } else {
            sb.append("No ratings available\n");
        }

        return sb.toString();
    }
}
