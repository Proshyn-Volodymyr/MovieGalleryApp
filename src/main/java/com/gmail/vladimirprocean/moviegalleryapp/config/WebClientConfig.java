package com.gmail.vladimirprocean.moviegalleryapp.config;

import com.gmail.vladimirprocean.moviegalleryapp.model.TmdbResponse;
import com.gmail.vladimirprocean.moviegalleryapp.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;
import java.util.function.Function;

@Configuration
@PropertySource("classpath:application.properties")
public class WebClientConfig implements WebFluxConfigurer {
    private String apiKey;

    public WebClientConfig(@Value("${tmdb.apiKey}") String apiKey) {
        this.apiKey = apiKey;
    }

    @Bean
    public WebClient getWebClient(){
        return WebClient.builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
//    @Bean
//    public Function<TmdbResponse, List<Movie>> tmdbResponseListFunction(){
//        return new Function<TmdbResponse, List<Movie>>() {
//            @Override
//            public List<Movie> apply(TmdbResponse tmdbResponse) {
//                return tmdbResponse.getMovies();
//            }
//        };
//    }
//    @Bean
//    public Function<UriBuilder, URI> trendingMoviesUri(@Value("${tmdb.apiKey}") final String apiKey){
//        return new Function<UriBuilder, URI>() {
//            @Override
//            public URI apply(UriBuilder uriBuilder) {
//                return uriBuilder.path("movie/now_playing")
//                        .queryParam("api_key", apiKey)
//                        .build();
//            }
//        };
//    }
}
