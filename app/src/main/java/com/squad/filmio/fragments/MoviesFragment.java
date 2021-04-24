package com.squad.filmio.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.squad.filmio.R;
import com.squad.filmio.api.methods.GetMovies;
import com.squad.filmio.api.methods.GetTv;
import com.squad.filmio.api.models.search.MovieResponse;
import com.squad.filmio.api.models.search.TvResponse;
import com.squad.filmio.ui.CoverModel;
import com.squad.filmio.ui.adapters.CoverAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesFragment extends Fragment {
    private ViewPager coverViewPager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movies, container, false);

        coverViewPager = root.findViewById(R.id.movies_fragment_view_pager);

        new Thread(() -> {
            new GetMovies().getUpcomingMovies().enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                    System.out.println(response.body().getResults());
                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {

                }
            });
        }).start();


        initViewPager();
        return root;
    }

    private void initViewPager() {
        List<CoverModel> coverModels = new ArrayList<>();
        CoverAdapter coverAdapter = new CoverAdapter(coverModels, getContext());
        coverViewPager.setAdapter(coverAdapter);
        coverViewPager.setPadding(120, 10, 120, 0);
        coverViewPager.setCurrentItem(1);
    }
}