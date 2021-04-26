package com.squad.filmio.api.models.tv;

import java.io.Serializable;

public class By implements Serializable {
    private int id;
    private String credit_id;
    private String name;
    private float gender;
    private String profile_path = null;


    // Getter Methods

    public int getId() {
        return id;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public String getName() {
        return name;
    }

    public float getGender() {
        return gender;
    }

    public String getProfile_path() {
        return profile_path;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(float gender) {
        this.gender = gender;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

}
