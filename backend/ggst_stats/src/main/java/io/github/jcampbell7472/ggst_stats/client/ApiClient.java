package io.github.jcampbell7472.ggst_stats.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import io.github.jcampbell7472.ggst_stats.dto.player.PlayerDTO;
import io.github.jcampbell7472.ggst_stats.dto.search.SearchPlayerListDTO;

@Service
public class ApiClient {

    private static final RestClient restClient = RestClient.create();

    public SearchPlayerListDTO searchPlayers(String str) {
        SearchPlayerListDTO searchResult = null;

        try {
            searchResult = restClient.get()
                    .uri("https://puddle.farm/api/player/search?search_string={str}&exact=true", str)
                    .retrieve()
                    .body(SearchPlayerListDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return searchResult;
    }

    public PlayerDTO getPlayerData(long id) {
        PlayerDTO playerData = null;

        try {
            playerData = restClient.get()
                    .uri("https://puddle.farm/api/player/{id}", id)
                    .retrieve()
                    .body(PlayerDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return playerData;
    }

}
