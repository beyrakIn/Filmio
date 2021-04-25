package com.squad.filmio.api;

import com.squad.filmio.api.models.discover.ReviewResult;
import com.squad.filmio.api.models.genre.Genre;
import com.squad.filmio.api.models.genre.GenreResponse;
import com.squad.filmio.api.models.movie.Movie;
import com.squad.filmio.api.models.people.Person;
import com.squad.filmio.api.models.people.PersonImage;
import com.squad.filmio.api.models.people.PersonMovieCredits;
import com.squad.filmio.api.models.people.PersonTvCredits;
import com.squad.filmio.api.models.search.CompanyResponse;
import com.squad.filmio.api.models.search.MovieResponse;
import com.squad.filmio.api.models.search.TvResponse;
import com.squad.filmio.api.models.translation.TranslationResponse;
import com.squad.filmio.api.models.video.VideoResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AppService {

    /**
     * Movies
     */

    @GET("movie/{movie_id}")
    Call<Movie> GET_MOVIE(
            @Query("api_key") String api_key,
            @Path("movie_id") int movie_id,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    @GET("movie/{movie_id}/videos")
    Call<VideoResult> GET_MOVIE_VIDEOS(
            @Query("api_key") String api_key,
            @Path("movie_id") int movie_id,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    @GET("movie/{movie_id}/recommendations")
    Call<MovieResponse> GET_RECOMMENDATIONS_MOVIES(
            @Query("api_key") String api_key,
            @Path("movie_id") int movie_id,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    @GET("movie/{movie_id}/reviews")
    Call<ReviewResult> GET_MOVIE_REVIEWS(
            @Query("api_key") String api_key,
            @Path("movie_id") int movie_id,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    @GET("movie/{movie_id}/similar")
    Call<MovieResponse> GET_SIMILAR_MOVIES(
            @Query("api_key") String api_key,
            @Path("movie_id") int movie_id,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    @GET("movie/{movie_id}/translations")
    Call<TranslationResponse> GET_TRANSLATIONS(
            @Query("api_key") String api_key,
            @Path("movie_id") int movie_id,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    @GET("movie/top_rated")
    Call<MovieResponse> GET_TOP_RELATED_MOVIES(
            @Query("api_key") String api_key,
            @Query("page") int page,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );


    @GET("movie/popular")
    Call<MovieResponse> GET_POPULAR_MOVIES(
            @Query("api_key") String api_key,
            @Query("page") int page,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );


    @GET("search/person")
    Call<Person> SEARCH_PERSON(
            @Query("api_key") String api_key,
            @Query("query") String query,
            @Query("page") int page,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    /**
     * Discover
     */

    @GET("discover/movie")
    Call<MovieResponse> GET_MOVIE_DISCOVER(
            @Query("api_key") String api_key,
            @Query("page") int page,
            @Query("language") String language,
            @Query("include_image_language") String image_language

    );

    @GET("discover/tv")
    Call<MovieResponse> GET_TV_DISCOVER(
            @Query("api_key") String api_key,
            @Query("page") int page,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    /**
     * Genres
     */
    @GET("genre/movie/list")
    Call<GenreResponse> GET_MOVIE_GENRES(
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    @GET("genre/tv/list")
    Call<GenreResponse> GET_TV_GENRES(
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    @GET("genre/{genre_id}")
    Call<Genre> GET_MOVIE_GENRE(
            @Path("genre_id") int genre_id,
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

//    @GET("genre/{genre_id}")
//    Call<Genre> GET_TV_GENRE(
//            @Path("genre_id") int genre_id,
//            @Query("api_key") String api_key,
//            @Query("language") String language,
//            @Query("include_image_language") String image_language
//    );


    /**
     * People
     */


    @GET("person/{person_id}")
    Call<Person> GET_PERSON(
            @Path("person_id") int person_id,
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );


    @GET("person/{person_id}/movie_credits")
    Call<PersonMovieCredits> GET_PERSON_MOVIE_CREDITS(
            @Path("person_id") int person_id,
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    @GET("person/{person_id}/tv_credits")
    Call<PersonTvCredits> GET_PERSON_TV_CREDITS(
            @Path("person_id") int person_id,
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

//    @GET("person/{person_id}/tv_credits")
//    Call<PersonTvCredits> GET_PERSON_COMBINED_CREDITS(
//            @Path("person_id") int person_id,
//            @Query("api_key") String api_key,
//            @Query("language") String language,
//            @Query("include_image_language") String image_language
//    );

    @GET("person/{person_id}/images")
    Call<PersonImage> GET_PERSON_IMAGES(
            @Path("person_id") int person_id,
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    @GET("person/{person_id}/images")
    Call<TranslationResponse> GET_PERSON_TRANSLATIONS(
            @Path("person_id") int person_id,
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

//    @GET("person/popular")
//    Call<Discover> GET_PERSON_POPULAR(
//            @Path("person_id") int person_id,
//            @Query("api_key") String api_key,
//            @Query("language") String language,
//            @Query("include_image_language") String image_language
//    );

    /**
     * TV
     */

    @GET("tv/popular")
    Call<TvResponse> GET_POPULAR_TV(
            @Query("api_key") String api_key,
            @Query("page") int page,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    @GET("tv/top_rated")
    Call<TvResponse> GET_TOP_RATED_TV(
            @Query("api_key") String api_key,
            @Query("page") int page,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    @GET("tv/{tv_id}/recommendations")
    Call<TvResponse> GET_RECOMMENDATIONS_TV(
            @Query("api_key") String api_key,
            @Path("tv_id") int tv_id,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );


    /**
     * Search
     */

    @GET("search/movie")
    Call<MovieResponse> SEARCH_MOVIE(
            @Query("api_key") String api_key,
            @Query("query") String query,
            @Query("page") int page,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    @GET("search/tv")
    Call<TvResponse> SEARCH_TV_SHOWS(
            @Query("api_key") String api_key,
            @Query("query") String query,
            @Query("page") int page,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

//    @GET("search/person")
//    Call<SearchCompany> SEARCH_PERSON(
//            @Query("api_key") String api_key,
//            @Query("query") String query,
//            @Query("language") String language,
//            @Query("include_image_language") String image_language
//    );

    @GET("person/popular")
    Call<CompanyResponse> SEARCH_COMPANY(
            @Query("api_key") String api_key,
            @Query("query") String query,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

    /**
     * UPCOMING*/

    @GET("movie/upcoming")
    Call<MovieResponse> GET_UPCOMING_MOVIE(
            @Query("api_key") String api_key,
            @Query("page") int page,
            @Query("language") String language,
            @Query("include_image_language") String image_language
    );

}
