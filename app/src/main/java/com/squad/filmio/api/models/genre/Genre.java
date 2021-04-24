package com.squad.filmio.api.models.genre;

import java.io.Serializable;

public class Genre implements Serializable {
    private int id;
    private String name;


    // Getter Methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
