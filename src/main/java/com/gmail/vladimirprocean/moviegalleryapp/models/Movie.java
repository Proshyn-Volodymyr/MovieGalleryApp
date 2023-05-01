package com.gmail.vladimirprocean.moviegalleryapp.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    private Integer id;
    private String poster_path;
    private String title;
    private String original_title;
    private Integer vote_count;
    private Double vote_average;
    private Double popularity;
    private String overview;
    private Date release_date;
    @ElementCollection
    private List<Integer> genre_ids;
}
