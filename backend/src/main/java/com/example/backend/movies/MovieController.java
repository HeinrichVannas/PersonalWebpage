package com.example.backend.movies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/movie/")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @CrossOrigin
    @GetMapping()
    public List<Movie> getMovies(){
        return movieService.getMovies();
        }

    @GetMapping("/data")
    public ResponseEntity<String> getSecureData() {
        return ResponseEntity.ok("Movie data");
    }

    @CrossOrigin
    @GetMapping("{title}")
    public List<Movie> getSingleMovie(@PathVariable String title) {
        String newTitle = '%' + title + '%';
        return movieService.getMoviesByTitle(newTitle);}

    @PostMapping
    public void registerNewMovie(@RequestBody Movie movie){
        movieService.addNewMovie(movie);
    }
    @DeleteMapping(path="{movieId}")
    public void deleteMovie(@PathVariable("movieId") Long movieId){
        movieService.deleteMovie(movieId);
    }
    @PutMapping(path="{movieId}")
    public void updateMovie(@PathVariable("movieId") Long movieId, @RequestParam(required = false) String poster){
        movieService.updateMovie(movieId, poster);
    }
    @RequestMapping(
            value = "/addMovies",
            method = RequestMethod.POST)
    public void addNewMovies(@RequestBody List<Map<String, String>> movies){
        for(Map<String, String> movie : movies){
            registerNewMovie(new Movie(movie.get("Title"), Integer.parseInt(movie.get("Year").replaceAll("[^0-9]", "")), movie.get("Type"), movie.get("Poster")));
        }
    }
}
