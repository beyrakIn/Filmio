package com.squad.filmio.api.methods;

import com.squad.filmio.api.AppService;
import com.squad.filmio.api.Config;
import com.squad.filmio.api.models.tv.TvResponse;

import java.util.Locale;

import retrofit2.Call;

public class GetTv {
    AppService appService;

    Locale locale = Locale.getDefault();
    private final String KEY = "33321493d08eb4e1a46e6ce27d379eb0";
    private final String LANG = locale.getLanguage();

    public Call<TvResponse> getPopularTv(int page) {
        appService = Config.retrofit.create(AppService.class);
        return appService.GET_POPULAR_TV(KEY, page, LANG, LANG);
    }

    public Call<TvResponse> getTopRatedTv() {
        appService = Config.retrofit.create(AppService.class);
        return appService.GET_TOP_RATED_TV(KEY, 1, "tr", "tr-TR");
    }
}
