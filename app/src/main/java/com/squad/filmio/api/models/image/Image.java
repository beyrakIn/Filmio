package com.squad.filmio.api.models.image;

import java.io.Serializable;

public class Image implements Serializable {
    private float aspect_ratio;
    private String file_path;
    private float height;
    private String iso_639_1 = null;
    private float vote_average;
    private float vote_count;
    private float width;


    // Getter Methods

    public float getAspect_ratio() {
        return aspect_ratio;
    }

    public String getFile_path() {
        return file_path;
    }

    public float getHeight() {
        return height;
    }

    public String getIso_639_1() {
        return iso_639_1;
    }

    public float getVote_average() {
        return vote_average;
    }

    public float getVote_count() {
        return vote_count;
    }

    public float getWidth() {
        return width;
    }

    // Setter Methods

    public void setAspect_ratio(float aspect_ratio) {
        this.aspect_ratio = aspect_ratio;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public void setVote_count(float vote_count) {
        this.vote_count = vote_count;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Image{" +
                "aspect_ratio=" + aspect_ratio +
                ", file_path='" + file_path + '\'' +
                ", height=" + height +
                ", iso_639_1='" + iso_639_1 + '\'' +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                ", width=" + width +
                '}';
    }
}
