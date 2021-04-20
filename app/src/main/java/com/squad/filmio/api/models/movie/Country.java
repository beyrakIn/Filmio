package com.squad.filmio.api.models.movie;

import java.io.Serializable;

public class Country implements Serializable {
    private String iso_3166_1;
    private String name;


    // Getter Methods

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public String getName() {
        return name;
    }

    // Setter Methods

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public void setName(String name) {
        this.name = name;
    }
}
