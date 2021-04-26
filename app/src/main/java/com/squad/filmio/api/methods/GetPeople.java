package com.squad.filmio.api.methods;

import com.squad.filmio.api.AppService;
import com.squad.filmio.api.Config;
import com.squad.filmio.api.models.person.Person;
import com.squad.filmio.api.models.person.PersonImage;
import com.squad.filmio.api.models.person.PersonMovieCredits;
import com.squad.filmio.api.models.person.PersonResponse;
import com.squad.filmio.api.models.person.PersonTvCredits;
import com.squad.filmio.api.models.translation.TranslationResponse;

import java.util.Locale;

import retrofit2.Call;

public class GetPeople {
    AppService appService = Config.retrofit.create(AppService.class);
    Locale locale = Locale.getDefault();
    private final String KEY = "33321493d08eb4e1a46e6ce27d379eb0";
    private final String LANG = locale.getLanguage();

    public Call<Person> getPerson() {
        return appService.GET_PERSON(4, "33321493d08eb4e1a46e6ce27d379eb0", "tr", "tr-TR");
    }

    public Call<PersonMovieCredits> getPersonMovieCredits() {
        return appService.GET_PERSON_MOVIE_CREDITS(4, "33321493d08eb4e1a46e6ce27d379eb0", "tr", "tr-TR");
    }

    public Call<PersonTvCredits> getPersonTvCredits() {
        return appService.GET_PERSON_TV_CREDITS(4, "33321493d08eb4e1a46e6ce27d379eb0", "tr", "tr-TR");
    }

    public Call<PersonImage> getPersonImages() {
        return appService.GET_PERSON_IMAGES(4, "33321493d08eb4e1a46e6ce27d379eb0", "tr", "tr-TR");
    }

    public Call<TranslationResponse> getPersonTranslation() {
        return appService.GET_PERSON_TRANSLATIONS(4, "33321493d08eb4e1a46e6ce27d379eb0", "tr", "tr-TR");
    }

    public Call<PersonResponse> getPopularActors(int page) {
        return appService.GET_POPULAR_PEOPLE(KEY, page, LANG, LANG);
    }
}
