package com.gmail.vladimirprocean.moviegalleryapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
@Service
public class VideoService {
    private final WebClient webClient;

    public VideoService(WebClient webClient) {
        this.webClient = webClient;
    }
}
