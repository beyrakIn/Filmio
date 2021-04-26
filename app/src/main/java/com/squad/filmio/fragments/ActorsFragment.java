package com.squad.filmio.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.squad.filmio.R;
import com.squad.filmio.api.methods.GetPeople;
import com.squad.filmio.api.models.person.Person;
import com.squad.filmio.api.models.person.PersonResponse;
import com.squad.filmio.ui.adapters.PersonAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActorsFragment extends Fragment {
    private View root;
    private RecyclerView recyclerView;
    private PersonAdapter adapter;
    private List<Person> people = new ArrayList<>();
    private int pageCount = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_actors, container, false);

        recyclerView = root.findViewById(R.id.fragment_actors_recycler);
        adapter = new PersonAdapter(getContext(), people);
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
            new GetPeople().getPopularActors(page).enqueue(new Callback<PersonResponse>() {
                @Override
                public void onResponse(Call<PersonResponse> call, Response<PersonResponse> response) {
                    if (response.isSuccessful()) {
                        people = response.body().getResults();
                        adapter.updateData(people);
                        pageCount++;
                    }
                }

                @Override
                public void onFailure(Call<PersonResponse> call, Throwable t) {

                }
            });
        }).start();
    }
}