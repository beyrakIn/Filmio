package com.squad.filmio.api.methods;

import com.squad.filmio.api.AppService;
import com.squad.filmio.api.Config;
import com.squad.filmio.api.models.search.TvResponse;

import retrofit2.Call;

public class GetTv {
    AppService appService;

    private final String KEY = "33321493d08eb4e1a46e6ce27d379eb0";

    public Call<TvResponse> getPopularTv() {
        appService = Config.retrofit.create(AppService.class);
        return appService.GET_POPULAR_TV( KEY,1, "tr", "tr-TR");
    }
}
