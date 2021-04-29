package com.squad.filmio.api.methods;

import com.squad.filmio.Constants;
import com.squad.filmio.api.AppService;
import com.squad.filmio.api.Config;
import com.squad.filmio.api.models.movie.MovieCredit;
import com.squad.filmio.api.models.tv.Tv;
import com.squad.filmio.api.models.tv.TvResponse;

import java.util.Locale;

import retrofit2.Call;

public class GetTv {
    AppService appService = Config.retrofit.create(AppService.class);
    Locale locale = Locale.getDefault();
    private final String KEY = Constants.API_KEY;
    private final String LANG = locale.getLanguage();

    public Call<TvResponse> getPopularTv(int page) {
        return appService.GET_POPULAR_TV(KEY, page, LANG, LANG);
    }

    public Call<TvResponse> getTopRatedTv(int page) {
        return appService.GET_TOP_RATED_TV(KEY, page, LANG, LANG);
    }

    public Call<Tv> getTvShow(int id) {
        return appService.GET_TV_SHOW(id, KEY, LANG, LANG);
    }


    public Call<MovieCredit> getTvActors(int id) {
        return appService.GET_TV_ACTORS(id, KEY, LANG, LANG);
    }
}
