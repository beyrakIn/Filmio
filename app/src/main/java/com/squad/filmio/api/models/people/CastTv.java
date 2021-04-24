package com.squad.filmio.api.models.people;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CastTv implements Serializable {
    private String original_name;
    List<String> origin_country = new ArrayList<>();
    List<Integer> genre_ids = new ArrayList<>();
    private float id;
    private float vote_count;
    private String first_air_date;
    private String name;
    private float vote_average;
    private String original_language;
    private String overview;
    private String poster_path;
    private String backdrop_path;
    private float popularity;
    private String character;
    private String credit_id;
    private float episode_count;


    // Getter Methods

    public String getOriginal_name() {
        return original_name;
    }

    public float getId() {
        return id;
    }

    public float getVote_count() {
        return vote_count;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public String getName() {
        return name;
    }

    public float getVote_average() {
        return vote_average;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public float getPopularity() {
        return popularity;
    }

    public String getCharacter() {
        return character;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public float getEpisode_count() {
        return episode_count;
    }

    // Setter Methods

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setVote_count(float vote_count) {
        this.vote_count = vote_count;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public void setEpisode_count(float episode_count) {
        this.episode_count = episode_count;
    }

    public List<String> getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(List<String> origin_country) {
        this.origin_country = origin_country;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    @Override
    public String toString() {
        return "CastTv{" +
                "original_name='" + original_name + '\'' +
                ", origin_country=" + origin_country +
                ", genre_ids=" + genre_ids +
                ", id=" + id +
                ", vote_count=" + vote_count +
                ", first_air_date='" + first_air_date + '\'' +
                ", name='" + name + '\'' +
                ", vote_average=" + vote_average +
                ", original_language='" + original_language + '\'' +
                ", overview='" + overview + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", popularity=" + popularity +
                ", character='" + character + '\'' +
                ", credit_id='" + credit_id + '\'' +
                ", episode_count=" + episode_count +
                '}';
    }
}
