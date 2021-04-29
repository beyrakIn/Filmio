package com.squad.filmio.api.models.person;

import com.squad.filmio.api.models.movie.Film;

import java.io.Serializable;

public class CreditTv extends Film implements Serializable {
    private String original_name;
    private int episode_count;
    private String name;
//    private int id;
//    private String poster_path;
//    private String backdrop_path;


    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public int getEpisode_count() {
        return episode_count;
    }

    public void setEpisode_count(int episode_count) {
        this.episode_count = episode_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CreditTv{" +
//                "id=" + id +
//                ", poster_path='" + poster_path + '\'' +
                ", name='" + name + '\'' +
//                ", backdrop_path='" + backdrop_path + '\'' +
                ", episode_count=" + episode_count +
                ", original_name='" + original_name + '\'' +
                '}';
    }
}
