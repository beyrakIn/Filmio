package com.squad.filmio.api.models.tv;

import java.io.Serializable;

public class Episode implements Serializable {
    private String air_date;
    private int episode_number;
    private int id;
    private String name;
    private String overview;
    private String production_code;
    private int season_number;
    private String still_path = null;
    private float vote_average;
    private int vote_count;


    // Getter Methods

    public String getAir_date() {
        return air_date;
    }

    public int getEpisode_number() {
        return episode_number;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOverview() {
        return overview;
    }

    public String getProduction_code() {
        return production_code;
    }

    public int getSeason_number() {
        return season_number;
    }

    public String getStill_path() {
        return still_path;
    }

    public float getVote_average() {
        return vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    // Setter Methods

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public void setEpisode_number(int episode_number) {
        this.episode_number = episode_number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setProduction_code(String production_code) {
        this.production_code = production_code;
    }

    public void setSeason_number(int season_number) {
        this.season_number = season_number;
    }

    public void setStill_path(String still_path) {
        this.still_path = still_path;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

}
