package com.gmail.vladimirprocean.moviegalleryapp.controller;

import com.gmail.vladimirprocean.moviegalleryapp.model.Movie;
import com.gmail.vladimirprocean.moviegalleryapp.service.MovieService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;
    @Value("${tmdb.apiKey}")
    private String apiKey;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
//    @GetMapping("/now_playing")
//    public Mono<List<Movie>> getTrendingMovies(@RequestParam("api_key") String apiKey){
//
//    return movieService.getMovies(apiKey);
//    }
    @GetMapping("/now_playing")
    public Mono<List<Movie>> getTrendingMovies(){
    return movieService.getTrendingMovies(apiKey);
    }

}
