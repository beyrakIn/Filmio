package com.squad.filmio.api.models.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonTvCredit implements Serializable {
    List<CreditTv> cast = new ArrayList<>();
    List<CreditTv> crew = new ArrayList<>();
    private int id;


    // Getter Methods

    public int getId() {
        return id;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public List<CreditTv> getCast() {
        return cast;
    }

    public void setCast(List<CreditTv> cast) {
        this.cast = cast;
    }

    public List<CreditTv> getCrew() {
        return crew;
    }

    public void setCrew(List<CreditTv> crew) {
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
