package com.example.backend.movies;


import jakarta.persistence.*;


@Entity
@Table
public class Movie {

    @Id
    @SequenceGenerator(name="movie_sequence", sequenceName = "movie_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_sequence")
    private Long id;
    private String title;
    private int year;
    private String type;
    private String poster;


    public Movie(String title, int year, String type, String poster) {
        this.title = title;
        this.year = year;
        this.type = type;
        this.poster = poster;
    }

    public Movie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        poster = poster;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", type='" + type + '\'' +
                ", Poster='" + poster + '\'' +
                '}';
    }
}

