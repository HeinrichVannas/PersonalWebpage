package com.example.backend.movies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return new ArrayList<>();//movieService.getMovies();
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
}
