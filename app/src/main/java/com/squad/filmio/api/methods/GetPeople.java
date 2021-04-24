package com.squad.filmio.api.methods;

import com.squad.filmio.api.AppService;
import com.squad.filmio.api.Config;
import com.squad.filmio.api.models.people.Person;
import com.squad.filmio.api.models.people.PersonMovieCredits;
import com.squad.filmio.api.models.people.PersonTvCredits;

import retrofit2.Call;

public class GetPeople {
    AppService appService;

    private final String KEY = "33321493d08eb4e1a46e6ce27d379eb0";

    public Call<Person> getPerson() {
        appService = Config.retrofit.create(AppService.class);
        return appService.GET_PERSON(4, "33321493d08eb4e1a46e6ce27d379eb0", "tr", "tr-TR");
    }

    public Call<PersonMovieCredits> getPersonMovieCredits() {
        appService = Config.retrofit.create(AppService.class);
        return appService.GET_PERSON_MOVIE_CREDITS(4, "33321493d08eb4e1a46e6ce27d379eb0", "tr", "tr-TR");
    }

    public Call<PersonTvCredits> getPersonTvCredits() {
        appService = Config.retrofit.create(AppService.class);
        return appService.GET_PERSON_TV_CREDITS(4, "33321493d08eb4e1a46e6ce27d379eb0", "tr", "tr-TR");
    }
}
