package com.gmail.vladimirprocean.moviegalleryapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MovieDetails {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("title")
    private String title;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("vote_count")
    private int voteCount;
    @JsonProperty("vote_average")
    private double voteAverage;
    @JsonProperty("popularity")
    private double popularity;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("genres")
    private ArrayList<Genre> genres;
    @JsonProperty("production_companies")
    private ArrayList<ProductionCompany> productionCompanies;
    @JsonProperty("production_countries")
    private ArrayList<ProductionCountry> productionCountries;

    public MovieDetails(Long id) {
        this.id = id;
    }
    public MovieDetails(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public ArrayList<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(ArrayList<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public ArrayList<ProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(ArrayList<ProductionCountry> productionCountries) {
        this.productionCountries = productionCountries;
    }
}
