package com.squad.filmio.api.methods;

import com.squad.filmio.Constants;
import com.squad.filmio.api.AppService;
import com.squad.filmio.api.Config;
import com.squad.filmio.api.models.company.CompanyResponse;
import com.squad.filmio.api.models.movie.MovieResponse;
import com.squad.filmio.api.models.person.Person;
import com.squad.filmio.api.models.person.PersonResponse;
import com.squad.filmio.api.models.tv.TvResponse;

import java.util.Locale;

import retrofit2.Call;

public class GetSearch {
    AppService appService = Config.retrofit.create(AppService.class);
    ;
    Locale locale = Locale.getDefault();
    private final String KEY = Constants.API_KEY;
    private final String LANG = locale.getLanguage();

    public Call<CompanyResponse> searchCompany(String query) {
        return appService.SEARCH_COMPANY(KEY, query, LANG, LANG);
    }

    public Call<TvResponse> searchTv(String query, int page) {
        return appService.SEARCH_TV_SHOWS(KEY, query, page, LANG, LANG);
    }

    public Call<MovieResponse> searchMovie(String query, int page) {
        return appService.SEARCH_MOVIE(KEY, query, page, LANG, LANG);
    }

    public Call<Person> searchActor(String query, int page) {
        return appService.SEARCH_PERSON(KEY, query, page, LANG, LANG);
    }


}
