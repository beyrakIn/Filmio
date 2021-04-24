package com.squad.filmio.api.models.people;

import com.squad.filmio.api.models.movie.Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonMovieCredits implements Serializable {
    List<CastMovie> cast = new ArrayList<>();
    List<CrewMovie> crew = new ArrayList<>();
    private float id;


    // Getter Methods

    public float getId() {
        return id;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public List<CastMovie> getCast() {
        return cast;
    }

    public void setCast(List<CastMovie> cast) {
        this.cast = cast;
    }

    public List<CrewMovie> getCrew() {
        return crew;
    }

    public void setCrew(List<CrewMovie> crew) {
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
