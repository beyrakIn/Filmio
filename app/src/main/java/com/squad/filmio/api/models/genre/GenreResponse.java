package com.squad.filmio.api.models.genre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenreResponse implements Serializable {
    List<Genre> genres = new ArrayList<>();

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "GenreResponse{" +
                "genres=" + genres +
                '}';
    }
}
