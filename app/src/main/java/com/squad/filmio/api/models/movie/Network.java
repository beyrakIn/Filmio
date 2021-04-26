package com.squad.filmio.api.models.movie;

import java.io.Serializable;

public class Network implements Serializable {
        private String name;
        private int id;
        private String logo_path;
        private String origin_country;


        // Getter Methods

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public String getLogo_path() {
            return logo_path;
        }

        public String getOrigin_country() {
            return origin_country;
        }

        // Setter Methods

        public void setName(String name) {
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setLogo_path(String logo_path) {
            this.logo_path = logo_path;
        }

        public void setOrigin_country(String origin_country) {
            this.origin_country = origin_country;
        }

    @Override
    public String toString() {
        return "Network{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", logo_path='" + logo_path + '\'' +
                ", origin_country='" + origin_country + '\'' +
                '}';
    }
}
