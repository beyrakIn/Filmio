package com.squad.filmio.api.methods;

import com.squad.filmio.Constants;
import com.squad.filmio.api.AppService;
import com.squad.filmio.api.Config;
import com.squad.filmio.api.models.person.Person;
import com.squad.filmio.api.models.person.PersonImage;
import com.squad.filmio.api.models.person.PersonMovieCredits;
import com.squad.filmio.api.models.person.PersonResponse;
import com.squad.filmio.api.models.person.PersonTvCredit;
import com.squad.filmio.api.models.translation.TranslationResponse;

import java.util.Locale;

import retrofit2.Call;

public class GetPeople {
    AppService appService = Config.retrofit.create(AppService.class);
    Locale locale = Locale.getDefault();
    private final String KEY = Constants.API_KEY;
    private final String LANG = locale.getLanguage();

    public Call<Person> getPerson(int id) {
        return appService.GET_PERSON(id, KEY, LANG, LANG);
    }

    public Call<PersonMovieCredits> getPersonMovieCredits(int id) {
        return appService.GET_PERSON_MOVIE_CREDITS(id, KEY, LANG, LANG);
    }

    public Call<PersonTvCredit> getPersonTvCredits(int id) {
        return appService.GET_PERSON_TV_CREDITS(id, KEY, LANG, LANG);
    }

    public Call<PersonImage> getPersonImages(int id) {
        return appService.GET_PERSON_IMAGES(id, KEY, LANG, LANG);
    }

    public Call<TranslationResponse> getPersonTranslation(int id) {
        return appService.GET_PERSON_TRANSLATIONS(id, KEY, LANG, LANG);
    }

    public Call<PersonResponse> getPopularActors(int page) {
        return appService.GET_POPULAR_PEOPLE(KEY, page, LANG, LANG);
    }
}
