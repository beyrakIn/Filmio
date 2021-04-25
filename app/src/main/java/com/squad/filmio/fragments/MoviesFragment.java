package com.squad.filmio.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import com.squad.filmio.R;
import com.squad.filmio.api.methods.GetGenres;
import com.squad.filmio.api.methods.GetMovies;
import com.squad.filmio.api.models.genre.Genre;
import com.squad.filmio.api.models.genre.GenreResponse;
import com.squad.filmio.api.models.movie.Movie;
import com.squad.filmio.api.models.search.MovieResponse;
import com.squad.filmio.ui.adapters.CoverAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesFragment extends Fragment {
    private View root, group;
    private ViewPager coverViewPager;
    private LinearLayout mainLinear;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_movies, container, false);

        coverViewPager = root.findViewById(R.id.movies_fragment_view_pager);
        mainLinear = root.findViewById(R.id.movies_fragment_main_linear);


        loadGenres();

        initViewPager();
        return root;
    }

    private void loadGenres() {
        new Thread(() -> {
            new GetGenres().getMoviesGenres().enqueue(new Callback<GenreResponse>() {
                @Override
                public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                        for (Genre genre : response.body().getGenres()) {
                            group = LayoutInflater.from(root.getContext()).inflate(R.layout.group_item, null, false);
                            TextView title = group.findViewById(R.id.group_title);
                            title.setOnClickListener(v ->{
//                                Navigation.findNavController(v).navigate(R.id.action_navigation_movies_to_viewAllFragment);
                            });
                            title.setText(genre.getName());
                            mainLinear.addView(group);
                        }
                    }
                }

                @Override
                public void onFailure(Call<GenreResponse> call, Throwable t) {

                }
            });
        }).start();
    }

    private void initViewPager() {
        List<Movie> movies = new ArrayList<>();

        new Thread(()->{
            new GetMovies().getPopularMovies().enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    if (response.isSuccessful()){
                        assert response.body() != null;
                        movies.addAll(response.body().getResults());
                        CoverAdapter coverAdapter = new CoverAdapter(movies, getContext());
                        coverViewPager.setAdapter(coverAdapter);
                        coverViewPager.setPadding(120, 10, 120, 0);
                        coverViewPager.setCurrentItem(1);
                    }
                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {

                }
            });
        }).start();
    }
}