package com.squad.filmio.api.models.company;

import java.io.Serializable;

public class Company implements Serializable {
    private int id;
    private String logo_path = null;
    private String name;
    private String origin_country;


    // Getter Methods

    public int getId() {
        return id;
    }

    public String getLogo_path() {
        return logo_path;
    }

    public String getName() {
        return name;
    }

    public String getOrigin_country() {
        return origin_country;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", logo_path='" + logo_path + '\'' +
                ", name='" + name + '\'' +
                ", origin_country='" + origin_country + '\'' +
                '}';
    }
}
