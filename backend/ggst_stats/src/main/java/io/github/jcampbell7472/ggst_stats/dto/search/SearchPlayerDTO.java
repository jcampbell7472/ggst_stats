package io.github.jcampbell7472.ggst_stats.dto.search;

public class SearchPlayerDTO {

    private Long id;
    private String name;
    private Float rating;
    private Float deviation;
    private String char_short;
    private String char_long;

    // No-args constructor for Jackson
    public SearchPlayerDTO() {}

    public SearchPlayerDTO (Long id, String name, Float rating, Float deviation, String char_short, String char_long) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.deviation = deviation;
        this.char_short = char_short;
        this.char_long = char_long;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId (Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Float getRating() { return rating; }
    public void setRating(Float rating) { this.rating = rating; }

    public Float getDeviation() { return deviation; }
    public void setDeviation(Float deviation) { this.deviation = deviation; }

    public String getChar_short() { return char_short; }
    public void setChar_short(String char_short) { this.char_short = char_short; }

    public String getChar_long() { return char_long; }
    public void setChar_long(String char_long) { this.char_long = char_long; }
}