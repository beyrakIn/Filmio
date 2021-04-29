package com.squad.filmio.api.models.person;

import com.squad.filmio.api.models.movie.Film;

import java.io.Serializable;

public class CreditMovie extends Film implements Serializable {
    private String title;
    private String original_title;
    private String release_date;
//    private int id;
//    private String poster_path;
//    private String backdrop_path;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @Override
    public String toString() {
        return "CreditMovie{" +
                "title='" + title + '\'' +
//                ", poster_path='" + poster_path + '\'' +
                ", original_title='" + original_title + '\'' +
//                ", id=" + id +
                ", release_date='" + release_date + '\'' +
//                ", backdrop_path='" + backdrop_path + '\'' +
                '}';
    }
}
