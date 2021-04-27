package com.squad.filmio.api.models.person;

import java.io.Serializable;

public class CreditMovie implements Serializable {
    private String title;
    private String poster_path;
    private String original_title;
    private int id;
    private String release_date;
    private String backdrop_path;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    @Override
    public String toString() {
        return "CreditMovie{" +
                "title='" + title + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", original_title='" + original_title + '\'' +
                ", id=" + id +
                ", release_date='" + release_date + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                '}';
    }
}
