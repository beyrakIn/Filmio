package com.squad.filmio.api.methods;

import com.squad.filmio.Constants;
import com.squad.filmio.api.AppService;
import com.squad.filmio.api.Config;
import com.squad.filmio.api.models.genre.Genre;
import com.squad.filmio.api.models.genre.GenreResponse;

import retrofit2.Call;

public class GetGenres {
    AppService appService;

    private final String KEY = Constants.API_KEY;
    private final String LANG = Constants.LANG;

    public Call<GenreResponse> getMoviesGenres() {
        appService = Config.retrofit.create(AppService.class);
        return appService.GET_MOVIE_GENRES(KEY, LANG, LANG);
    }

    public Call<GenreResponse> getTvGenres() {
        appService = Config.retrofit.create(AppService.class);
        return appService.GET_TV_GENRES(KEY, LANG, LANG);
    }


    public Call<Genre> getMoviesGenre(int id) {
        appService = Config.retrofit.create(AppService.class);
        return appService.GET_MOVIE_GENRE(id, KEY, LANG, LANG);
    }


//    public Call<GenreResponse> getTvGenre(int id) {
//        appService = Config.retrofit.create(AppService.class);
//        return appService.GET_TV_GENRES(KEY, "tr", "tr-TR");
//    }
}
