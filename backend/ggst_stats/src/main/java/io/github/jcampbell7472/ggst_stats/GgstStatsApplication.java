package io.github.jcampbell7472.ggst_stats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class GgstStatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GgstStatsApplication.class, args);
	}

	@GetMapping
	public String helloWorld(){
		return "Hello World from GGST stats";
	}

}
