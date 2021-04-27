package com.squad.filmio.api.models.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonMovieCredits implements Serializable {
    List<CreditMovie> cast = new ArrayList<>();
    List<CreditMovie> crew = new ArrayList<>();
    private int id;


    // Getter Methods

    public int getId() {
        return id;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public List<CreditMovie> getCast() {
        return cast;
    }

    public void setCast(List<CreditMovie> cast) {
        this.cast = cast;
    }

    public List<CreditMovie> getCrew() {
        return crew;
    }

    public void setCrew(List<CreditMovie> crew) {
        this.crew = crew;
    }

    @Override
    public String toString() {
        return "MovieCredits{" +
                "cast=" + cast +
                ", crew=" + crew +
                ", id=" + id +
                '}';
    }
}
