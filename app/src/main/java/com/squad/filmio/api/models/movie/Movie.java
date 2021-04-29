package com.squad.filmio.api.models.movie;

import com.squad.filmio.api.models.company.Company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie extends Film implements Serializable {
    private boolean adult;
    private Collection belongs_to_collection = new Collection();
    private float budget;
    private String imdb_id;
    private String original_title;
    List<Company> production_companies = new ArrayList<>();
    List<Country> production_countries = new ArrayList<>();
    private String release_date;
    private float revenue;
    private float runtime;
    private boolean video;
    private String title;
//    private String backdrop_path;
//    List<Integer> genre_ids = new ArrayList<>();
//    List<Genre> genres = new ArrayList<>();
//    private String homepage;
//    private int id;
//    private String original_language;
//    private String overview;
//    private float popularity;
//    private String poster_path;
//    private float vote_count;
//    private float vote_average;
//    List<Language> spoken_languages = new ArrayList<>();
//    private String status;
//    private String tagline;


    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public Collection getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public void setBelongs_to_collection(Collection belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public List<Company> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<Company> production_companies) {
        this.production_companies = production_companies;
    }

    public List<Country> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<Country> production_countries) {
        this.production_countries = production_countries;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public float getRuntime() {
        return runtime;
    }

    public void setRuntime(float runtime) {
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }
}
