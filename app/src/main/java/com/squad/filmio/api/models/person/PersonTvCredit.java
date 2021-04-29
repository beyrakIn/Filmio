package com.squad.filmio.api.models.person;

import com.squad.filmio.api.models.movie.Film;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonTvCredit implements Serializable {
    List<Film> cast = new ArrayList<>();
    List<Film> crew = new ArrayList<>();
    private int id;


    public List<Film> getCast() {
        return cast;
    }

    public void setCast(List<Film> cast) {
        this.cast = cast;
    }

    public List<Film> getCrew() {
        return crew;
    }

    public void setCrew(List<Film> crew) {
        this.crew = crew;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonTvCredits{" +
                "cast=" + cast +
                ", crew=" + crew +
                ", id=" + id +
                '}';
    }
}
