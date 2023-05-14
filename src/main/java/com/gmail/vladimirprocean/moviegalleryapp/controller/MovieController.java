package com.gmail.vladimirprocean.moviegalleryapp.controller;

import com.gmail.vladimirprocean.moviegalleryapp.model.Movie;
import com.gmail.vladimirprocean.moviegalleryapp.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/now_playing")
    public Mono<List<Movie>> getTrendingMovies(@RequestParam("api_key") String apiKey){
    return movieService.getMovies(apiKey);
    }

}
