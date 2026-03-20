package io.github.jcampbell7472.ggst_stats.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.github.jcampbell7472.ggst_stats.client.ApiClient;
import io.github.jcampbell7472.ggst_stats.dto.player.PlayerDTO;
import io.github.jcampbell7472.ggst_stats.dto.search.SearchPlayerDTO;
import io.github.jcampbell7472.ggst_stats.dto.search.SearchPlayerListDTO;

/**
 *
 * @author jake
 */
@RestController
public class PlayerController {

    private final ApiClient apiClient;

    public PlayerController(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @GetMapping("/player/{name}")
	public PlayerDTO getPlayerDTO(@PathVariable String name){
		//call the API client to search for the player's name, returns an object with a list of matching players
		SearchPlayerListDTO playerList = apiClient.searchPlayers(name);

		//check if any players were found
		if(playerList.getResults()==null || playerList.getResults().isEmpty()){
			throw new RuntimeException("Player not found...");
		}

		//if players were found, then get the first one in the list
		SearchPlayerDTO playerSearch = playerList.getResults().get(0);
		//grab the player's id
		Long playerId = playerSearch.getId();

		//call the API client to search for a specific player using their ID
		PlayerDTO player = apiClient.getPlayerData(playerId);

		//check if the player exists or has any ratings
		if(player==null || player.getRatings().isEmpty()){
            throw new RuntimeException("Player not found...");
		}

		return player;
	}

}
