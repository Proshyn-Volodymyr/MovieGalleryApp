package com.gmail.vladimirprocean.moviegalleryapp.service;

import com.gmail.vladimirprocean.moviegalleryapp.model.Movie;
import com.gmail.vladimirprocean.moviegalleryapp.model.TmdbResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MovieService {
    private static final String BASE_URL = "https://api.themoviedb.org/3";
    private final WebClient webClient;
//    private final Function<UriBuilder, URI> trendingMoviesUri;
//    private final Function<TmdbResponse, List<Movie>> tmbResponseMapper;

//    public MovieService(WebClient.Builder webClientBuilder, Function<UriBuilder, URI> trendingMoviesUri, Function<TmdbResponse, List<Movie>> tmbResponseMapper) {
//        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
//        this.trendingMoviesUri = trendingMoviesUri;
//        this.tmbResponseMapper = tmbResponseMapper;
//    }

    public MovieService(WebClient webClient) {
        this.webClient = webClient;
    }


//            public Mono<List<Movie>> getMovies(String apiKey){
////        URI uri = trendingMoviesUri.apply(UriComponentsBuilder.newInstance());
//
//            return webClient.get()
//                    .uri("/movie/now_playing?api_key={apiKey}", apiKey)
//                    .retrieve()
//                    .bodyToMono(TmdbResponse.class)
//                    .map(tmbResponseMapper);
//    }
    public Mono<List<Movie>> getMovies(String apiKey){
        return webClient.get()
                .uri("/movie/popular?api_key={apiKey}", apiKey)
                .retrieve()
                .bodyToMono(TmdbResponse.class)
                .map(TmdbResponse::getResults);

    }

}
