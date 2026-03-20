package io.github.jcampbell7472.ggst_stats.dto.search;

import java.util.List;

/**
 *
 * @author jake
 */
public class SearchPlayerListDTO {

    private List<SearchPlayerDTO> results;

    public SearchPlayerListDTO(){}

    public SearchPlayerListDTO(List<SearchPlayerDTO> results) {
        this.results = results;
    }

    public List<SearchPlayerDTO> getResults() {
        return results;
    }

    public void setResults(List<SearchPlayerDTO> results) {
        this.results = results;
    }
    
}
