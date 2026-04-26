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
            System.out.println("Searching for player ID...");
            searchResult = restClient.get()
                    .uri("https://puddle.farm/api/player/search?search_string={str}&exact=true", str)
                    .retrieve()
                    .body(SearchPlayerListDTO.class);
        } catch (Exception e) {
            System.err.println("Error retrieving player ID");
            return null;
        }
        System.out.println("Success!");
        return searchResult;
    }

    public PlayerDTO getPlayerData(long id) {
        System.out.println("Searching for player data...");
        PlayerDTO playerData = null;

        try {
            playerData = restClient.get()
                    .uri("https://puddle.farm/api/player/{id}", id)
                    .retrieve()
                    .body(PlayerDTO.class);
        } catch (Exception e) {
            System.err.println("Error retrieving player data");
            return null;
        }

        System.out.println("Success!");
        return playerData;
    }

}
