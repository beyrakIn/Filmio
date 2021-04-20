package com.squad.filmio.api.models.movie;

import java.io.Serializable;

public class Genre implements Serializable {
    private float id;
    private String name;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
