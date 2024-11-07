package com.example.backend.movies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Configuration
public class MovieConfig {
    private static Logger log = LogManager.getLogger(MovieConfig.class);
    @Bean
    CommandLineRunner commandLineRunner(MovieRepository movieRepository){
        return args -> {
            log.info("Movies in the database on startup: " + movieRepository.findAll());
        };
    }
}
