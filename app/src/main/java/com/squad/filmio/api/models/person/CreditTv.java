package com.squad.filmio.api.models.person;

import java.io.Serializable;

public class CreditTv implements Serializable {
    private int id;
    private String poster_path;
    private String name;
    private String backdrop_path;
    private int episode_count;
    private String original_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public int getEpisode_count() {
        return episode_count;
    }

    public void setEpisode_count(int episode_count) {
        this.episode_count = episode_count;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    @Override
    public String toString() {
        return "CreditTv{" +
                "id=" + id +
                ", poster_path='" + poster_path + '\'' +
                ", name='" + name + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", episode_count=" + episode_count +
                ", original_name='" + original_name + '\'' +
                '}';
    }
}
