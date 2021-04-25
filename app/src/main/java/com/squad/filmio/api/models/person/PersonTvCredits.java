package com.squad.filmio.api.models.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonTvCredits implements Serializable {
    List<CastTv> cast = new ArrayList<>();
    List<CastMovie> crew = new ArrayList<>();
    private int id;


    // Getter Methods

    public int getId() {
        return id;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public List<CastTv> getCast() {
        return cast;
    }

    public void setCast(List<CastTv> cast) {
        this.cast = cast;
    }

    public List<CastMovie> getCrew() {
        return crew;
    }

    public void setCrew(List<CastMovie> crew) {
        this.crew = crew;
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
