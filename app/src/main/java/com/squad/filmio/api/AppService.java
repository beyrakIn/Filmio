package com.squad.filmio.api;

import com.squad.filmio.api.models.discover.Discover;
import com.squad.filmio.api.models.discover.ReviewResult;
import com.squad.filmio.api.models.movie.Genre;
import com.squad.filmio.api.models.movie.Movie;
import com.squad.filmio.api.models.people.Person;
import com.squad.filmio.api.models.translation.TranslationResult;
import com.squad.filmio.api.models.video.VideoResult;

import java.util.List;

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
            @Path("movie_id") int movie_id
    );

    @GET("movie/{movie_id}/videos")
    Call<VideoResult> GET_MOVIE_VIDEOS(
            @Query("api_key") String api_key,
            @Path("movie_id") int movie_id
    );

    @GET("movie/{movie_id}/recommendations")
    Call<Discover> GET_RECOMMENDATIONS_MOVIES(
            @Query("api_key") String api_key,
            @Path("movie_id") int movie_id
    );

    @GET("movie/{movie_id}/reviews")
    Call<ReviewResult> GET_MOVIE_REVIEWS(
            @Query("api_key") String api_key,
            @Path("movie_id") int movie_id
    );

    @GET("movie/{movie_id}/similar")
    Call<Discover> GET_SIMILAR_MOVIES(
            @Query("api_key") String api_key,
            @Path("movie_id") int movie_id
    );

    @GET("movie/{movie_id}/translations")
    Call<TranslationResult> GET_TRANSLATIONS(
            @Query("api_key") String api_key,
            @Path("movie_id") int movie_id
    );

    @GET("movie/top_rated")
    Call<Discover> GET_TOP_RELATED_MOVIES(
            @Query("api_key") String api_key,
            @Query("page") int page
    );


    @GET("movie/popular")
    Call<Discover> GET_POPULAR_MOVIES(
            @Query("api_key") String api_key,
            @Query("page") int page
    );

    @GET("search/movie")
    Call<Discover> SEARCH_MOVIE(
            @Query("api_key") String api_key,
            @Query("query") String query,
            @Query("page") int page
    );

    @GET("search/person")
    Call<Person> SEARCH_PERSON(
            @Query("api_key") String api_key,
            @Query("query") String query,
            @Query("page") int page
    );

    /**
     * Discover
     */

    @GET("discover/movie")
    Call<Discover> GET_MOVIE_DISCOVER(
            @Query("api_key") String api_key,
            @Query("page") int page

    );

    @GET("discover/tv")
    Call<Discover> GET_TV_DISCOVER(
            @Query("api_key") String api_key,
            @Query("page") int page
    );

    /**
     * Genres
     */
    @GET("genre/movie/list")
    Call<List<Genre>> GET_MOVIE_GENRES(
            @Query("api_key") String api_key
    );

    @GET("genre/tv/list")
    Call<List<Genre>> GET_TV_GENRES(
            @Query("api_key") String api_key
    );


}
