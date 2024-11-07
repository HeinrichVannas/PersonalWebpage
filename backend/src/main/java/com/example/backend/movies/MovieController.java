package com.example.backend.movies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(path = "api/v1/movie/")
public class MovieController {
    private static Logger log = LogManager.getLogger(MovieController.class);
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @CrossOrigin
    @GetMapping()
    public List<Movie> getMovies(){
        log.info("All movies returned (getMovies API)");
        return movieService.getMovies();
        }

    @CrossOrigin
    @GetMapping("{title}")
    public List<Movie> getSingleMovie(@PathVariable String title) {
        log.info("All movies with title that contain the keyword: " + title + ", returned (getMovies API)");
        String newTitle = '%' + title + '%';
        return movieService.getMoviesByTitle(newTitle);}

    @PostMapping("protected")
    public void registerNewMovie(@RequestBody Movie movie){
        log.info("Registering new Movie: ");
        movieService.addNewMovie(movie);
    }
    @DeleteMapping(path="protected/{movieId}")
    public void deleteMovie(@PathVariable("movieId") Long movieId){
        movieService.deleteMovie(movieId);
    }
    @PutMapping(path="protected/{movieId}")
    public void updateMovie(@PathVariable("movieId") Long movieId, @RequestParam(required = false) String poster){
        movieService.updateMovie(movieId, poster);
    }
    @RequestMapping(
            value = "protected/addMovies",
            method = RequestMethod.POST)
    public void addNewMovies(@RequestBody List<Map<String, String>> movies){
        log.info("Registering new Movies: " + movies);
        for(Map<String, String> movie : movies){
            registerNewMovie(new Movie(movie.get("Title"), Integer.parseInt(movie.get("Year").replaceAll("[^0-9]", "")), movie.get("Type"), movie.get("Poster")));
        }
    }
}
