package com.squad.filmio.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.squad.filmio.R;
import com.squad.filmio.api.methods.GetGenres;
import com.squad.filmio.api.methods.GetMovies;
import com.squad.filmio.api.models.genre.Genre;
import com.squad.filmio.api.models.genre.GenreResponse;
import com.squad.filmio.api.models.movie.Movie;
import com.squad.filmio.api.models.movie.MovieResponse;
import com.squad.filmio.ui.adapters.CoverAdapter;
import com.squad.filmio.ui.adapters.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesFragment extends Fragment {
    private View root, group;
    private ViewPager coverViewPager;
    private LinearLayout mainLinear;
    private RecyclerView popularRecyclerView;
    private List<Movie> movies = new ArrayList<>();
    private int pageCount = 1;
    private MovieAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_movies, container, false);
        group = LayoutInflater.from(root.getContext()).inflate(R.layout.group_item, null, false);

        coverViewPager = root.findViewById(R.id.movies_fragment_view_pager);
        mainLinear = root.findViewById(R.id.movies_fragment_main_linear);
//        popularRecyclerView = group.findViewById(R.id.group_recycler_view);
        popularRecyclerView = root.findViewById(R.id.fragment_movies_recycler);
        adapter = new MovieAdapter(getContext(), movies);
        popularRecyclerView.setAdapter(adapter);
        popularRecyclerView.setHasFixedSize(false);
        popularRecyclerView.setItemViewCacheSize(150);

        loadData(pageCount);
        initScroll();
        initViewPager();
        return root;
    }

    private void initScroll() {
        popularRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView2, int newState) {
                super.onScrollStateChanged(recyclerView2, newState);
                if (!popularRecyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    loadData(pageCount);
                }
            }
        });
    }

    private void loadData(int page) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.group_item, null);
        new Thread(() -> {
            new GetMovies().getPopularMovies(page).enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                        movies = response.body().getResults();
                        adapter.updateData(movies);
                        pageCount++;
                    }
                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {
                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    loadData(pageCount);
                }
            });
        }).start();
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
//                            title.setOnClickListener(v -> {
//                                Navigation.findNavController(v).navigate(R.id.action_navigation_movies_to_movieDetailsFragment);
//                            });
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

        new Thread(() -> {
            new GetMovies().getPopularMovies(pageCount).enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                        movies.addAll(response.body().getResults());
                        CoverAdapter coverAdapter = new CoverAdapter(movies, getContext());
                        coverViewPager.setAdapter(coverAdapter);
                        coverViewPager.setPadding(220, 10, 300, 10);
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
