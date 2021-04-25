package com.squad.filmio.api.models.person;

import com.squad.filmio.api.models.image.Image;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonImage implements Serializable {
    private float id;
    List<Image> profiles = new ArrayList<>();


    // Getter Methods

    public float getId() {
        return id;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public List<Image> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Image> profiles) {
        this.profiles = profiles;
    }

    @Override
    public String toString() {
        return "PersonImage{" +
                "id=" + id +
                ", profiles=" + profiles +
                '}';
    }
}
