package com.squad.filmio.api.methods;

import com.squad.filmio.api.AppService;
import com.squad.filmio.api.Config;
import com.squad.filmio.api.models.genre.GenreResponse;

import retrofit2.Call;

public class GetGenres {
    AppService appService;

    private final String KEY = "33321493d08eb4e1a46e6ce27d379eb0";

    public Call<GenreResponse> getMoviesGenres() {
        appService = Config.retrofit.create(AppService.class);
        return appService.GET_MOVIE_GENRES("33321493d08eb4e1a46e6ce27d379eb0", "tr", "tr-TR");
    }

    public Call<GenreResponse> getTvGenres() {
        appService = Config.retrofit.create(AppService.class);
        return appService.GET_TV_GENRES("33321493d08eb4e1a46e6ce27d379eb0", "tr", "tr-TR");
    }
}
