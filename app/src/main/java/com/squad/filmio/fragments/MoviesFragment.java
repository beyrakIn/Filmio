package com.squad.filmio.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.squad.filmio.R;
import com.squad.filmio.ui.CoverModel;
import com.squad.filmio.ui.adapters.CoverAdapter;

import java.util.ArrayList;
import java.util.List;

public class MoviesFragment extends Fragment {
    private ViewPager coverViewPager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movies, container, false);

        coverViewPager = root.findViewById(R.id.movies_fragment_view_pager);


        initViewPager();
        return root;
    }

    private void initViewPager() {
        List<CoverModel> coverModels = new ArrayList<>();
        CoverAdapter coverAdapter = new CoverAdapter(coverModels, getContext());
        coverViewPager.setAdapter(coverAdapter);
        coverViewPager.setPadding(100, 0, 100, 0);
    }
}