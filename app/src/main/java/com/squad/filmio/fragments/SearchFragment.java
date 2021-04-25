package com.squad.filmio.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.squad.filmio.R;
import com.squad.filmio.api.methods.GetTv;
import com.squad.filmio.api.models.tv.Tv;
import com.squad.filmio.api.models.tv.TvResponse;
import com.squad.filmio.ui.adapters.TvAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {
    private RecyclerView recyclerView;
    private TvAdapter adapter;
    private List<Tv> tvs = new ArrayList<>();
    private int pageCount = 1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView = root.findViewById(R.id.fragment_tv_recycler);
        adapter = new TvAdapter(getContext(), tvs);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(150);


        loadData(pageCount);
        initScroll();
        return root;
    }

    private void initScroll() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView2, int newState) {
                super.onScrollStateChanged(recyclerView2, newState);
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    loadData(pageCount);
                }
            }
        });
    }

    private void loadData(int page) {
        new Thread(() -> {
            new GetTv().getPopularTv(page).enqueue(new Callback<TvResponse>() {
                @Override
                public void onResponse(Call<TvResponse> call, Response<TvResponse> response) {
                    if (response.isSuccessful()) {
                        tvs = response.body().getResults();
                        adapter.updateData(tvs);
                        pageCount++;
                    }
                }

                @Override
                public void onFailure(Call<TvResponse> call, Throwable t) {
                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    loadData(pageCount);
                }
            });
        }).start();
    }
}