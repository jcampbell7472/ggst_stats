package io.github.jcampbell7472.ggst_stats.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.jcampbell7472.ggst_stats.client.ApiClient;

@SpringBootApplication
@RestController
public class GgstStatsApplication {

	static ApiClient apiClient = new ApiClient();

	public static void main(String[] args) {
		SpringApplication.run(GgstStatsApplication.class, args);
	}

	@GetMapping
	public static String helloWorld(){
		//return ApiClient.getPlayerDataString(211225142910485027L);
		return apiClient.searchPlayers("kinetic__").toString();
	}

}
