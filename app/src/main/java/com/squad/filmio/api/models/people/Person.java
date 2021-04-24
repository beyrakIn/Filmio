package com.squad.filmio.api.models.people;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private boolean adult;
    List<String> also_known_as = new ArrayList<>();
    private String biography;
    private String birthday;
    private String deathday;
    private float gender;
    private String homepage;
    private float id;
    private String imdb_id;
    private String known_for_department;
    private String name;
    private String place_of_birth;
    private float popularity;
    private String profile_path;


    // Getter Methods

    public boolean getAdult() {
        return adult;
    }

    public String getBiography() {
        return biography;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDeathday() {
        return deathday;
    }

    public float getGender() {
        return gender;
    }

    public String getHomepage() {
        return homepage;
    }

    public float getId() {
        return id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public String getKnown_for_department() {
        return known_for_department;
    }

    public String getName() {
        return name;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public float getPopularity() {
        return popularity;
    }

    public String getProfile_path() {
        return profile_path;
    }

    // Setter Methods

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setDeathday(String deathday) {
        this.deathday = deathday;
    }

    public void setGender(float gender) {
        this.gender = gender;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public void setKnown_for_department(String known_for_department) {
        this.known_for_department = known_for_department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public List<String> getAlso_known_as() {
        return also_known_as;
    }

    public void setAlso_known_as(List<String> also_known_as) {
        this.also_known_as = also_known_as;
    }

    @Override
    public String toString() {
        return "Person{" +
                "adult=" + adult +
                ", also_known_as=" + also_known_as +
                ", biography='" + biography + '\'' +
                ", birthday='" + birthday + '\'' +
                ", deathday='" + deathday + '\'' +
                ", gender=" + gender +
                ", homepage='" + homepage + '\'' +
                ", id=" + id +
                ", imdb_id='" + imdb_id + '\'' +
                ", known_for_department='" + known_for_department + '\'' +
                ", name='" + name + '\'' +
                ", place_of_birth='" + place_of_birth + '\'' +
                ", popularity=" + popularity +
                ", profile_path='" + profile_path + '\'' +
                '}';
    }
}
