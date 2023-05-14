package com.gmail.vladimirprocean.moviegalleryapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TmdbResponse {
    private int page;
    private List<Movie> results;
    private int totalPage;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "TmdbResponse{" +
                "page=" + page +
                ", movies=" + results +
                ", totalPage=" + totalPage +
                '}';
    }
}
