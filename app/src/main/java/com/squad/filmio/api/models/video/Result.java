package com.squad.filmio.api.models.video;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Result implements Serializable {
    private float id;
    List<Video> results = new ArrayList<>();


    // Getter Methods

    public float getId() {
        return id;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

}
