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

    public PlayerDTO() {}

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
        sb.append("Player{");
        sb.append("\nid=").append(id);
        sb.append(",\n name=").append(name);
        sb.append(",\n ratings=").append(ratings);
        sb.append(",\n platform=").append(platform);
        sb.append(",\n topGlobal=").append(topGlobal);
        sb.append('}');
        return sb.toString();
    }

}
