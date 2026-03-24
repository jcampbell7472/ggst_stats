package io.github.jcampbell7472.ggst_stats;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.jcampbell7472.ggst_stats.bot.DiscordBot;

@SpringBootApplication
public class GgstStatsApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GgstStatsApplication.class, args);
	}

	@Bean
	CommandLineRunner runBot(DiscordBot bot) {
		return args -> bot.start();
	}
}
