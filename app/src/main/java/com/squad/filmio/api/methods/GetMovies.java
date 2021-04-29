package com.squad.filmio.api.methods;

import com.squad.filmio.Constants;
import com.squad.filmio.api.AppService;
import com.squad.filmio.api.Config;
import com.squad.filmio.api.models.movie.Movie;
import com.squad.filmio.api.models.movie.MovieCredit;
import com.squad.filmio.api.models.movie.MovieResponse;

import java.util.Locale;

import retrofit2.Call;

public class GetMovies {
    AppService appService = Config.retrofit.create(AppService.class);
    Locale locale = Locale.getDefault();
    private final String KEY = Constants.API_KEY;
    private final String LANG = locale.getLanguage();

    public Call<MovieResponse> getPopularMovies(int page) {
        return appService.GET_POPULAR_MOVIES(KEY, page, LANG, LANG);
    }

    public Call<MovieResponse> getUpcomingMovies(int page) {
        return appService.GET_UPCOMING_MOVIE(KEY, page, LANG, LANG);
    }

    public Call<Movie> getMovie(int id) {
        return appService.GET_MOVIE(id, KEY, LANG, LANG);
    }

    public Call<MovieCredit> getMovieCredits(int id) {
        return appService.GET_MOVIE_CREDITS(id, KEY, LANG, LANG);
    }

}
