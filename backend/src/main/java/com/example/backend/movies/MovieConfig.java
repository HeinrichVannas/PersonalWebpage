package com.example.backend.movies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class MovieConfig {
    @Bean
    CommandLineRunner commandLineRunner(MovieRepository movieRepository){
        return args -> {
            Movie Shrek = new Movie("shrek", 2001, "movie", "https://m.media-amazon.com/images/M/MV5BOGZhM2FhNTItODAzNi00YjA0LWEyN2UtNjJlYWQzYzU1MDg5L2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg");
            Movie Shrek2 = new Movie("Shrek 2", 2004, "movie", "https://m.media-amazon.com/images/M/MV5BMDJhMGRjN2QtNDUxYy00NGM3LThjNGQtMmZiZTRhNjM4YzUxL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg");
            Movie CaptainMarvel = new Movie("Captain Marvel", 2019, "movie", "https://m.media-amazon.com/images/M/MV5BZDI1NGU2ODAtNzBiNy00MWY5LWIyMGEtZjUxZjUwZmZiNjBlXkEyXkFqcGc@._V1_SX300.jpg");
            Movie Spiderman = new Movie("Spiderman", 1990, "movie", "https://assets.mycast.io/posters/spider-man-1990-fan-casting-poster-138879-medium.jpg?1634512779");

            movieRepository.saveAll(List.of(Shrek, Shrek2, CaptainMarvel, Spiderman));
        };
    }
}
