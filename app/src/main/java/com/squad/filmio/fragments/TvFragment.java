package com.squad.filmio.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

public class TvFragment extends Fragment {
    private Activity activity;
    private RelativeLayout loader;
    private RecyclerView recyclerView;
    private TvAdapter adapter;
    private List<Tv> tvs = new ArrayList<>();
    private int pageCount = 1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tv, container, false);
        activity = (AppCompatActivity) root.getContext();
        activity.getWindow().clearFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        loader = root.findViewById(R.id.relative_loader);
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
        try {
            new Thread(() -> {
                new GetTv().getPopularTv(page).enqueue(new Callback<TvResponse>() {
                    @Override
                    public void onResponse(Call<TvResponse> call, Response<TvResponse> response) {
                        if (response.isSuccessful()) {
                            tvs.addAll(response.body().getResults());
                            adapter.updateData(tvs);
                            pageCount++;

                            if (loader.getVisibility() == View.VISIBLE){
                                loader.removeAllViewsInLayout();
                                loader.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<TvResponse> call, Throwable t) {
                        new Handler().postDelayed(() -> {
                            loadData(pageCount);
                        }, 5000);
                    }
                });
            }).start();
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getCause().getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        tvs.clear();
    }
}