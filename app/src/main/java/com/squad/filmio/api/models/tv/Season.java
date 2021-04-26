package com.squad.filmio.api.models.tv;

import java.io.Serializable;

public class Season implements Serializable {
    private String air_date;
    private int episode_count;
    private int id;
    private String name;
    private String overview;
    private String poster_path;
    private int season_number;


    // Getter Methods

    public String getAir_date() {
        return air_date;
    }

    public int getEpisode_count() {
        return episode_count;
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

    public String getPoster_path() {
        return poster_path;
    }

    public int getSeason_number() {
        return season_number;
    }

    // Setter Methods

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public void setEpisode_count(int episode_count) {
        this.episode_count = episode_count;
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

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setSeason_number(int season_number) {
        this.season_number = season_number;
    }

    @Override
    public String toString() {
        return "Season{" +
                "air_date='" + air_date + '\'' +
                ", episode_count=" + episode_count +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", season_number=" + season_number +
                '}';
    }
}
