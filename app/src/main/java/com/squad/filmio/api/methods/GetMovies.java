package com.squad.filmio.api.methods;

import android.content.Context;
import android.widget.Toast;

import com.squad.filmio.api.AppService;
import com.squad.filmio.api.Config;
import com.squad.filmio.api.models.movie.Movie;
import com.squad.filmio.api.models.movie.MovieResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetMovies {
    AppService appService;

    Locale locale = Locale.getDefault();
    private final String KEY = "33321493d08eb4e1a46e6ce27d379eb0";
    private final String LANG = locale.getLanguage();

    public Call<MovieResponse> getPopularMovies(int page) {
        appService = Config.retrofit.create(AppService.class);
        return appService.GET_POPULAR_MOVIES(KEY, page, LANG, LANG);
    }

    public Call<MovieResponse> getUpcomingMovies(int page) {
        appService = Config.retrofit.create(AppService.class);
        return appService.GET_UPCOMING_MOVIE(KEY, page, LANG, LANG);
    }

    public Call<Movie> getMovie(int id) {
        appService = Config.retrofit.create(AppService.class);
        return appService.GET_MOVIE(id, KEY, LANG, LANG);
    }

}
