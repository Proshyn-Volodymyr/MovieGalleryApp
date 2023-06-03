package com.gmail.vladimirprocean.moviegalleryapp.service;
import com.gmail.vladimirprocean.moviegalleryapp.model.Movie;
import com.gmail.vladimirprocean.moviegalleryapp.model.TmdbResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MovieService {
    private final WebClient webClient;

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

}
