package com.gmail.vladimirprocean.moviegalleryapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libraries")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "library")
    private User user;

    public Library() {
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="libraries_movies", joinColumns = @JoinColumn(name="libraries_id"), inverseJoinColumns = @JoinColumn(name = "movies_id"))
    private List<Movie> movies;
}
