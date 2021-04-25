package com.squad.filmio.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squad.filmio.R;
import com.squad.filmio.api.methods.GetMovies;
import com.squad.filmio.api.models.movie.Movie;
import com.squad.filmio.api.models.search.MovieResponse;
import com.squad.filmio.ui.adapters.UpcomingAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    View root;
    List<Movie> movies = new ArrayList<>();
    RecyclerView recyclerView;
    int pageCount = 1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.upcoming_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(root.getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        loadData(pageCount);
        initScroll();
        return root;
    }

    private void initScroll() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    try {
                        loadData(pageCount);
                    } catch (Exception e) {
                        Log.e("scroll", e.getMessage());
                    }
                }
            }
        });
    }

    private void loadData(int page) {
        new Thread(() -> {
            new GetMovies().getUpcomingMovies(page).enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    if (response.isSuccessful()) {
                        MovieResponse movieResponse = response.body();
                        assert movieResponse != null;
                        movies.addAll(movieResponse.getResults());
                        UpcomingAdapter adapter = new UpcomingAdapter(getContext(), movies);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setItemViewCacheSize(150);
//                        adapter.notifyDataSetChanged();
                        pageCount++;
                    }
                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {
                }
            });
        }).start();
    }
}