package com.squad.filmio.api.models.tv;

import com.squad.filmio.api.models.company.Company;
import com.squad.filmio.api.models.genre.Genre;
import com.squad.filmio.api.models.movie.Country;
import com.squad.filmio.api.models.movie.Language;
import com.squad.filmio.api.models.movie.Network;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tv implements Serializable {
    private String backdrop_path;
    private String first_air_date;
    List<Integer> genre_ids = new ArrayList<>();
    private int id;
    private String name;
    List<String> origin_country = new ArrayList<>();
    private String original_language;
    private String original_name;
    private String overview;
    private float popularity;
    private String poster_path;
    private float vote_average;
    private float vote_count;

    List<Object> created_by = new ArrayList<>();
    List<Integer> episode_run_time = new ArrayList<>();
    List<Genre> genres = new ArrayList<>();
    private String homepage;
    private boolean in_production;
    List<String> languages = new ArrayList<>();
    private String last_air_date;
    private Episode next_episode_to_air = new Episode();
    private Episode last_episode_to_air = new Episode();
    List<Network> networks = new ArrayList<>();
    private float number_of_episodes;
    private float number_of_seasons;
    List<Company> production_companies = new ArrayList<>();
    List<Country> production_countries = new ArrayList<>();
    List<Season> seasons = new ArrayList<>();
    List<Language> spoken_languages = new ArrayList<>();
    private String status;
    private String tagline;
    private String type;


    // Getter Methods

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public String getOverview() {
        return overview;
    }

    public float getPopularity() {
        return popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public float getVote_average() {
        return vote_average;
    }

    public float getVote_count() {
        return vote_count;
    }

    // Setter Methods

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public void setVote_count(float vote_count) {
        this.vote_count = vote_count;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public List<String> getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(List<String> origin_country) {
        this.origin_country = origin_country;
    }

    public List<Object> getCreated_by() {
        return created_by;
    }

    public void setCreated_by(List<Object> created_by) {
        this.created_by = created_by;
    }

    public List<Integer> getEpisode_run_time() {
        return episode_run_time;
    }

    public void setEpisode_run_time(List<Integer> episode_run_time) {
        this.episode_run_time = episode_run_time;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public boolean isIn_production() {
        return in_production;
    }

    public void setIn_production(boolean in_production) {
        this.in_production = in_production;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getLast_air_date() {
        return last_air_date;
    }

    public void setLast_air_date(String last_air_date) {
        this.last_air_date = last_air_date;
    }

    public Episode getNext_episode_to_air() {
        return next_episode_to_air;
    }

    public void setNext_episode_to_air(Episode next_episode_to_air) {
        this.next_episode_to_air = next_episode_to_air;
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    public float getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(float number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

    public float getNumber_of_seasons() {
        return number_of_seasons;
    }

    public void setNumber_of_seasons(float number_of_seasons) {
        this.number_of_seasons = number_of_seasons;
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

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public List<Language> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(List<Language> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Episode getLast_episode_to_air() {
        return last_episode_to_air;
    }

    public void setLast_episode_to_air(Episode last_episode_to_air) {
        this.last_episode_to_air = last_episode_to_air;
    }

    @Override
    public String toString() {
        return "Tv{" +
                "backdrop_path='" + backdrop_path + '\'' +
                ", first_air_date='" + first_air_date + '\'' +
                ", genre_ids=" + genre_ids +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", origin_country=" + origin_country +
                ", original_language='" + original_language + '\'' +
                ", original_name='" + original_name + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", poster_path='" + poster_path + '\'' +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                '}';
    }
}
