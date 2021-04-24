package com.squad.filmio.api.models.people;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CrewTv implements Serializable {
    private String backdrop_path;
    private String first_air_date;
    List<Integer> genre_ids = new ArrayList<>();
    private float id;
    private String name;
    List<String> origin_country = new ArrayList<>();
    private String original_language;
    private String original_name;
    private String overview;
    private String poster_path;
    private float vote_average;
    private float vote_count;
    private float popularity;
    private String credit_id;
    private String department;
    private float episode_count;
    private String job;


    // Getter Methods

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public float getId() {
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

    public String getPoster_path() {
        return poster_path;
    }

    public float getVote_average() {
        return vote_average;
    }

    public float getVote_count() {
        return vote_count;
    }

    public float getPopularity() {
        return popularity;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public String getDepartment() {
        return department;
    }

    public float getEpisode_count() {
        return episode_count;
    }

    public String getJob() {
        return job;
    }

    // Setter Methods

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public void setId(float id) {
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

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public void setVote_count(float vote_count) {
        this.vote_count = vote_count;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEpisode_count(float episode_count) {
        this.episode_count = episode_count;
    }

    public void setJob(String job) {
        this.job = job;
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

    @Override
    public String toString() {
        return "CrewTv{" +
                "backdrop_path='" + backdrop_path + '\'' +
                ", first_air_date='" + first_air_date + '\'' +
                ", genre_ids=" + genre_ids +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", origin_country=" + origin_country +
                ", original_language='" + original_language + '\'' +
                ", original_name='" + original_name + '\'' +
                ", overview='" + overview + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                ", popularity=" + popularity +
                ", credit_id='" + credit_id + '\'' +
                ", department='" + department + '\'' +
                ", episode_count=" + episode_count +
                ", job='" + job + '\'' +
                '}';
    }
}
