package com.squad.filmio.api.models.discover;

import com.squad.filmio.api.models.movie.Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Discover implements Serializable {
    private float page;
    List<Movie> results = new ArrayList<>();
    private float total_pages;
    private float total_results;


    // Getter Methods

    public float getPage() {
        return page;
    }

    public float getTotal_pages() {
        return total_pages;
    }

    public float getTotal_results() {
        return total_results;
    }

    // Setter Methods

    public void setPage(float page) {
        this.page = page;
    }

    public void setTotal_pages(float total_pages) {
        this.total_pages = total_pages;
    }

    public void setTotal_results(float total_results) {
        this.total_results = total_results;
    }
}
