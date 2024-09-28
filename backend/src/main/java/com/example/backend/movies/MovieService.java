package com.example.backend.movies;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(){return movieRepository.findAll();}
    public Optional<Movie> getMovie(String title){return movieRepository.findMovieByTitle(title);}
    public List<Movie> getMoviesByTitle(String title){return movieRepository.findByTitleLikeIgnoreCase(title);}

    public void addNewMovie(Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findMovieByTitle(movie.getTitle());
        if(movieOptional.isPresent()) throw new IllegalStateException("Movie exists");
        movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        boolean exists = movieRepository.existsById(movieId);
        if(!exists) throw new IllegalStateException("Movie with id: " + movieId + " doesn't exist.");
        movieRepository.deleteById(movieId);
    }
    @Transactional
    public void updateMovie(Long movieId, String poster) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(()-> new IllegalStateException("Movie with id: "+ movieId + " does not exist."));
        if(poster != null && !poster.isEmpty() && !Objects.equals(movie.getPoster(), poster)) movie.setPoster(poster);

    }
}
