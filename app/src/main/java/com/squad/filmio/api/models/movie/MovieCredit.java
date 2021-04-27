package com.squad.filmio.api.models.movie;

import com.squad.filmio.api.models.person.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovieCredit implements Serializable {
    private int id;
    List<Person> cast = new ArrayList<>();
//    List<Person> crew = new ArrayList<>();


    // Getter Methods

    public int getId() {
        return id;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public List<Person> getCast() {
        return cast;
    }

    public void setCast(List<Person> cast) {
        this.cast = cast;
    }

}
