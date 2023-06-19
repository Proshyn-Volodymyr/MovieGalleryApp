package com.gmail.vladimirprocean.moviegalleryapp.service;
import com.gmail.vladimirprocean.moviegalleryapp.model.Movie;
import com.gmail.vladimirprocean.moviegalleryapp.model.MovieDetails;
import com.gmail.vladimirprocean.moviegalleryapp.model.TmdbResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MovieService {
    private final WebClient webClient;
    @Value("${tmdb.apiKey}")
    private String apiKey;

    public MovieService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<List<Movie>> getTrendingMovies(String apiKey){
        return webClient.get()
                .uri("/movie/popular?api_key={apiKey}", apiKey)
                .retrieve()
                .bodyToMono(TmdbResponse.class)
                .map(TmdbResponse::getResults);
    }
    public Mono<MovieDetails> getMovieDetails(int id){
        return webClient.get()
                .uri("/movie/" + id + "?api_key="+ apiKey) // brake the code
//                .uri("/movie/" + id)
                .retrieve()
                .bodyToMono(MovieDetails.class);
    }

}
