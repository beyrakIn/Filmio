package com.squad.filmio.api.models.translation;

import java.io.Serializable;

public class Translation implements Serializable {
    private String iso_3166_1;
    private String iso_639_1;
    private String name;
    private String english_name;
    Data data;


    // Getter Methods

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public String getIso_639_1() {
        return iso_639_1;
    }

    public String getName() {
        return name;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public Data getData() {
        return data;
    }

    // Setter Methods

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Codebeautify{" +
                "iso_3166_1='" + iso_3166_1 + '\'' +
                ", iso_639_1='" + iso_639_1 + '\'' +
                ", name='" + name + '\'' +
                ", english_name='" + english_name + '\'' +
                ", DataObject=" + data +
                '}';
    }


    public class Data {
        private String title;
        private String tagline;
        private int runtime;
        private String overview;
        private String homepage;
        private String biography;


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTagline() {
            return tagline;
        }

        public void setTagline(String tagline) {
            this.tagline = tagline;
        }

        public int getRuntime() {
            return runtime;
        }

        public void setRuntime(int runtime) {
            this.runtime = runtime;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getHomepage() {
            return homepage;
        }

        public void setHomepage(String homepage) {
            this.homepage = homepage;
        }

        public String getBiography() {
            return biography;
        }

        public void setBiography(String biography) {
            this.biography = biography;
        }
    }

}
