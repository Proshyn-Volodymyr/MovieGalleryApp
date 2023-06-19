package com.gmail.vladimirprocean.moviegalleryapp.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "libraries")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "library")
    private User user;
    @ElementCollection
    private Set<Integer> watchedMovies;

    public Library() {
    }

    public Set<Integer> getWatchedMovies() {
        return watchedMovies;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="libraries_movies", joinColumns = @JoinColumn(name="libraries_id"), inverseJoinColumns = @JoinColumn(name = "movies_id"))
    private List<Movie> movies;
}
