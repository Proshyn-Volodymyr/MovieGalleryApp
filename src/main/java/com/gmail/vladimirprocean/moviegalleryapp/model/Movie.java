package com.gmail.vladimirprocean.moviegalleryapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonProperty("poster_path")
    private String poster_path;
    @JsonProperty("title")
    private String title;
    @JsonProperty("original_title")
    private String original_title;
    @JsonProperty("vote_count")
    private Integer vote_count;
    @JsonProperty("vote_average")
    private Double vote_average;
    @JsonProperty("popularity")
    private Double popularity;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("release_date")
    private Date release_date;

    @ElementCollection
    @CollectionTable(name = "movies_genre_ids", joinColumns = @JoinColumn(name = "movie_id"))
    private List<Integer> genre_ids;
    @ManyToMany(mappedBy = "movies")
    private List<Library> libraries;

    public Movie() {
    }

    public Movie(Integer id, String poster_path, String title, String original_title, Integer vote_count, Double vote_average, Double popularity, String overview, Date release_date, List<Integer> genre_ids) {
        this.id = id;
        this.poster_path = poster_path;
        this.title = title;
        this.original_title = original_title;
        this.vote_count = vote_count;
        this.vote_average = vote_average;
        this.popularity = popularity;
        this.overview = overview;
        this.release_date = release_date;
        this.genre_ids = genre_ids;
    }
}
