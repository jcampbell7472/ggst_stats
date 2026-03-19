package io.github.jcampbell7472.ggst_stats.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import io.github.jcampbell7472.ggst_stats.dto.player.PlayerDTO;
import io.github.jcampbell7472.ggst_stats.dto.search.SearchResponseDTO;

@Service
public class ApiClient {

    private static RestClient restClient = RestClient.create();

    public SearchResponseDTO searchPlayers(String str) {
        SearchResponseDTO searchResult = null;

        try {
            searchResult = restClient.get()
                    .uri("/player/search?search_string={str}&exact=true", str)
                    .retrieve()
                    .body(SearchResponseDTO.class);
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

    public static String getPlayerDataString(long id) {
        String playerData = null;

        try {
            playerData = restClient.get()
                    .uri("https://puddle.farm/api/player/{id}", id)
                    .retrieve()
                    .body(String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return playerData;
    }

}
