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

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.squad.filmio.R;
import com.squad.filmio.api.methods.GetPeople;
import com.squad.filmio.api.models.person.Person;
import com.squad.filmio.api.models.person.PersonResponse;
import com.squad.filmio.ui.adapters.ActorAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActorsFragment extends Fragment {
    private Activity activity;
    private View root;
    private RelativeLayout loader;
    private RecyclerView recyclerView;
    private ActorAdapter adapter;
    private List<Person> people = new ArrayList<>();
    private int pageCount = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_actors, container, false);
        activity = (AppCompatActivity) root.getContext();
        activity.getWindow().clearFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        recyclerView = root.findViewById(R.id.fragment_actors_recycler);
        loader = root.findViewById(R.id.fragment_actors_loader);
        adapter = new ActorAdapter(getContext(), people, R.id.action_navigation_actors_to_actorInfoFragment);
        recyclerView.setAdapter(adapter);
//        recyclerView.setHasFixedSize(true);
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
                new GetPeople().getPopularActors(page).enqueue(new Callback<PersonResponse>() {
                    @Override
                    public void onResponse(Call<PersonResponse> call, Response<PersonResponse> response) {
                        if (response.isSuccessful()) {
                            people.addAll(response.body().getResults());
                            adapter.updateData(people);
                            pageCount++;

                            if (loader.getVisibility() == View.VISIBLE) {
                                loader.removeAllViewsInLayout();
                                loader.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<PersonResponse> call, Throwable t) {
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
        people.clear();
    }
}