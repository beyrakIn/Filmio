package com.squad.filmio.api.models.discover;

import com.squad.filmio.api.models.movie.Review;

import java.io.Serializable;
import java.util.List;

public class ReviewResult implements Serializable {
    private int total_results;
    private int total_pages;
    private List<Review> results;
    private int page;
    private int id;

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Review> getResults() {
        return results;
    }



    public void setResults(List<Review> results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
