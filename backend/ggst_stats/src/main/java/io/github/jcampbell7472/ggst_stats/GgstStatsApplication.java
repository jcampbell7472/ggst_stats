package io.github.jcampbell7472.ggst_stats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import io.github.jcampbell7472.ggst_stats.bot.DiscordBot;

@SpringBootApplication
public class GgstStatsApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context =
                SpringApplication.run(GgstStatsApplication.class, args);

        // AFTER Spring is fully started
        DiscordBot bot = context.getBean(DiscordBot.class);
        bot.start();
    }
}
