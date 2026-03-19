package io.github.jcampbell7472.ggst_stats.dto.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerDTO {

    private long id;
    private String name;
    private List<RatingDTO> ratings;
    private String platform;
    private String status;
    @JsonProperty("top_global")
    private int topGlobal;

    public PlayerDTO() {
    }

    @Autowired
    public PlayerDTO(long id, String name, List<RatingDTO> ratings, String platform, String status, int topGlobal) {
        this.id = id;
        this.name = name;
        this.ratings = ratings;
        this.platform = platform;
        this.status = status;
        this.topGlobal = topGlobal;
    }

    public long getId() {
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

    public String getStatus() {
        return status;
    }

    public int getTopGlobal() {
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
        sb.append(",\n status=").append(status);
        sb.append(",\n topGlobal=").append(topGlobal);
        sb.append('}');
        return sb.toString();
    }

}
