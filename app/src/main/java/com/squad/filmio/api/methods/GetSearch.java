package com.squad.filmio.api.methods;

import com.squad.filmio.api.AppService;
import com.squad.filmio.api.Config;
import com.squad.filmio.api.models.company.CompanyResponse;
import com.squad.filmio.api.models.movie.MovieResponse;
import com.squad.filmio.api.models.tv.TvResponse;

import retrofit2.Call;

public class GetSearch {
    AppService appService;

    private final String KEY = "33321493d08eb4e1a46e6ce27d379eb0";

    public Call<CompanyResponse> searchCompany() {
        appService = Config.retrofit.create(AppService.class);
        return appService.SEARCH_COMPANY( KEY,"marvel", "tr", "tr-TR");
    }

    public Call<TvResponse> searchTv() {
        appService = Config.retrofit.create(AppService.class);
        return appService.SEARCH_TV_SHOWS( KEY,"Falcon ve Kış Askeri", 1,"tr", "tr-TR");
    }

    public Call<MovieResponse> searchMovie() {
        appService = Config.retrofit.create(AppService.class);
        return appService.SEARCH_MOVIE( KEY,"Captain America", 1,"tr", "tr-TR");
    }


}
