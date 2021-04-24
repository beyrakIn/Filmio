package com.squad.filmio.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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
    LinearLayout linearLayout;
    View root, group;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);
        group = inflater.inflate(R.layout.group_item, container, false);


        initUpcoming();
        return root;
    }

    private void initUpcoming() {
        List<Movie> movies = new ArrayList<>();
        linearLayout = root.findViewById(R.id.home_fragment_linear_layout);
        linearLayout.addView(group);
        RecyclerView recyclerView = root.findViewById(R.id.group_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(root.getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        new GetMovies().getUpcomingMovies().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    MovieResponse movieResponse = response.body();
                    movies.addAll(movieResponse.getResults());
                    UpcomingAdapter adapter = new UpcomingAdapter(getContext(), movies);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setItemViewCacheSize(150);
                    adapter.notifyDataSetChanged();
                }
                System.out.println(response.code());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
            }
        });
    }
}