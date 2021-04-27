package com.squad.filmio.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squad.filmio.Constants;
import com.squad.filmio.R;
import com.squad.filmio.api.methods.GetMovies;
import com.squad.filmio.api.methods.GetTv;
import com.squad.filmio.api.models.genre.Genre;
import com.squad.filmio.api.models.movie.Movie;
import com.squad.filmio.api.models.movie.MovieCredit;
import com.squad.filmio.api.models.tv.Tv;
import com.squad.filmio.ui.adapters.ActorAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsFragment extends Fragment {
    private View root;
    private Activity activity;
    private LinearLayout linearLayout;
    private ImageView poster, backdrop;
    private TextView title, subTitle, genres, overview, runtime, releaseDate;
    private int movieId, tvId;
    private GetMovies getMovies = new GetMovies();
    private GetTv getTv = new GetTv();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_movie_details, container, false);
        activity = (AppCompatActivity) root.getContext();
        activity.getWindow().setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP, Intent.FLAG_ACTIVITY_CLEAR_TOP);

        linearLayout = root.findViewById(R.id.fragment_movie_details_linear);
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
            getTv.getTvShow(tv).enqueue(new Callback<Tv>() {
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
            //FILM ACTORS
            System.out.println("START   " + tv);
            getTv.getTvActors(tv).enqueue(new Callback<MovieCredit>() {
                @Override
                public void onResponse(Call<MovieCredit> call, Response<MovieCredit> response) {
                    if (response.isSuccessful()) {
                        MovieCredit movieCredit = response.body();
                        View cast = LayoutInflater.from(root.getContext()).inflate(R.layout.group_item, null, false);
                        TextView castTitle = cast.findViewById(R.id.group_title);
                        castTitle.setText("ACTORS");
                        RecyclerView castRecyclerView = cast.findViewById(R.id.group_recycler_view);
                        ActorAdapter actorAdapter = new ActorAdapter(getContext(), movieCredit.getCast(), R.id.action_movieDetailsFragment_to_actorInfoFragment);
                        castRecyclerView.setAdapter(actorAdapter);
//                        actorAdapter.updateData(movieCredits.getCast());
                        if (movieCredit.getCast().size() != 0 && movieCredit.getCast() != null) {
                            linearLayout.addView(cast);
                        }
                        System.out.println(movieCredit.getCast().toArray().toString() + "erorrr");
                    }
                    System.out.println(response.message());
                }

                @Override
                public void onFailure(Call<MovieCredit> call, Throwable t) {
                    System.out.println("AAAAAAAAAAAAAA" + t.getMessage());
                }
            });
        }).start();
    }

    private void getMovie(int movieId) {
        new Thread(() -> {
            getMovies.getMovie(movieId).enqueue(new Callback<Movie>() {
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
//            FILM ACTORS
            getMovies.getMovieCredits(movieId).enqueue(new Callback<MovieCredit>() {
                @Override
                public void onResponse(Call<MovieCredit> call, Response<MovieCredit> response) {
                    if (response.isSuccessful()) {
                        MovieCredit movieCredit = response.body();
                        View cast = LayoutInflater.from(root.getContext()).inflate(R.layout.group_item, null, false);
                        TextView castTitle = cast.findViewById(R.id.group_title);
                        castTitle.setText("ACTORS");
                        RecyclerView castRecyclerView = cast.findViewById(R.id.group_recycler_view);
                        ActorAdapter actorAdapter = new ActorAdapter(getContext(), movieCredit.getCast(), R.id.action_movieDetailsFragment_to_actorInfoFragment);
                        castRecyclerView.setAdapter(actorAdapter);

//                        actorAdapter.updateData();
                        if (movieCredit.getCast().size() != 0 && movieCredit.getCast() != null) {
                            linearLayout.addView(cast);
                        }
                    }
                }

                @Override
                public void onFailure(Call<MovieCredit> call, Throwable t) {

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