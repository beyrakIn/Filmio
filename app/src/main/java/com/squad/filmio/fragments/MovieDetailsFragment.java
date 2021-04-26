package com.squad.filmio.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.squad.filmio.Constants;
import com.squad.filmio.R;
import com.squad.filmio.api.methods.GetMovies;
import com.squad.filmio.api.methods.GetTv;
import com.squad.filmio.api.models.genre.Genre;
import com.squad.filmio.api.models.movie.Movie;
import com.squad.filmio.api.models.tv.Tv;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsFragment extends Fragment {
    private View root;
    private Activity activity;
    private ImageView poster, backdrop;
    private TextView title, subTitle, genres, overview, runtime, releaseDate;
    private int movieId, tvId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_movie_details, container, false);
        activity = (AppCompatActivity) root.getContext();
        activity.getWindow().setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP, Intent.FLAG_ACTIVITY_CLEAR_TOP);

        backdrop = root.findViewById(R.id.fragment_movie_details_backdrop);
        poster = root.findViewById(R.id.fragment_movie_details_poster);
        overview = root.findViewById(R.id.fragment_movie_details_overview);
        title = root.findViewById(R.id.fragment_movie_details_title);
        genres = root.findViewById(R.id.fragment_movie_details_genres);
        runtime = root.findViewById(R.id.fragment_movie_details_runtime);
        releaseDate = root.findViewById(R.id.fragment_movie_details_release_date);

        Bundle args = getArguments();
        movieId = args.getInt("movieId", 0);
        tvId = args.getInt("tvId", 0);
        if (movieId != 0) {
            getMovie(movieId);
        } else if (tvId != 0) {
            getTv(tvId);
        }

        return root;
    }

    private void getTv(int tv) {
        new Thread(() -> {
            new GetTv().getTvShow(tv).enqueue(new Callback<Tv>() {
                @Override
                public void onResponse(Call<Tv> call, Response<Tv> response) {
                    if (response.isSuccessful()) {
                        Tv tv = response.body();
                        overview.setText(tv.getOverview());
                        Glide.with(root)
                                .load(Constants.BACK_SRC + tv.getBackdrop_path())
                                .into(backdrop);
                        Glide.with(root)
                                .load(Constants.POSTER_SRC + tv.getPoster_path())
                                .into(poster);

                        title.setText(tv.getName());
                        for (Genre genre : tv.getGenres()) {
                            genres.setText(genres.getText() + genre.getName() + "/");
                        }
                        runtime.setText(String.valueOf(""));
                        releaseDate.setText(tv.getFirst_air_date());
                    }
                }

                @Override
                public void onFailure(Call<Tv> call, Throwable t) {
                    getTv(tvId);
                }
            });
        }).start();
    }

    private void getMovie(int movieId) {
        new Thread(() -> {
//            299536
            new GetMovies().getMovie(movieId).enqueue(new Callback<Movie>() {
                @Override
                public void onResponse(Call<Movie> call, Response<Movie> response) {
                    if (response.isSuccessful()) {
                        Movie movie = response.body();
                        overview.setText(movie.getOverview());
                        Glide.with(root)
                                .load(Constants.BACK_SRC + movie.getBackdrop_path())
                                .into(backdrop);
                        Glide.with(root)
                                .load(Constants.POSTER_SRC + movie.getPoster_path())
                                .into(poster);

                        title.setText(movie.getTitle());
                        for (Genre genre : movie.getGenres()) {
                            genres.setText(genres.getText() + genre.getName() + "/");
                        }
                        runtime.setText(String.valueOf((int) movie.getRuntime()));
                        releaseDate.setText(movie.getRelease_date());
                    }
                }

                @Override
                public void onFailure(Call<Movie> call, Throwable t) {
                    getMovie(movieId);
                }
            });
        }
        ).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        activity.getWindow().clearFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @Override
    public void onPause() {
        super.onPause();
        activity.getWindow().clearFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @Override
    public void onResume() {
        super.onResume();
        activity.getWindow().setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP, Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }
}