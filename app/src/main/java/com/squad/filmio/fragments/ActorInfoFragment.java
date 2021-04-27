package com.squad.filmio.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squad.filmio.Constants;
import com.squad.filmio.R;
import com.squad.filmio.api.methods.GetPeople;
import com.squad.filmio.api.models.person.CreditMovie;
import com.squad.filmio.api.models.person.CreditTv;
import com.squad.filmio.api.models.person.Person;
import com.squad.filmio.api.models.person.PersonMovieCredits;
import com.squad.filmio.api.models.person.PersonTvCredits;
import com.squad.filmio.ui.adapters.MovieCreditAdapter;
import com.squad.filmio.ui.adapters.TvCreditAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActorInfoFragment extends Fragment {
    private View root;
    private Activity activity;
    private LinearLayout linearLayout;
    private ImageView picture;
    private TextView actorName, placeOfBirth, popularity, birthday, biography, knownForDepartment;
    private int id;
    private GetPeople getPeople = new GetPeople();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_actor_info, container, false);
        activity = (AppCompatActivity) root.getContext();
        activity.getWindow().setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP, Intent.FLAG_ACTIVITY_CLEAR_TOP);

        linearLayout = root.findViewById(R.id.actor_info_main_linear);
        picture = root.findViewById(R.id.actors_info_picture);
        actorName = root.findViewById(R.id.actor_info_actor_name);
        placeOfBirth = root.findViewById(R.id.actor_info_place_of_birth);
//        popularity = root.findViewById(R.id.actor_info_popularity);
        knownForDepartment = root.findViewById(R.id.actor_info_known_for_department);
        birthday = root.findViewById(R.id.actor_info_birthday);
        biography = root.findViewById(R.id.actor_info_biography);

        Bundle args = getArguments();
        id = args.getInt("actorId", 0);
        getMovieCredits(id);
        getTvCredits(id);
        loadData(id);
        return root;
    }

    private void getTvCredits(int id) {
        new Thread(() -> {
            getPeople.getPersonTvCredits(id).enqueue(new Callback<PersonTvCredits>() {
                @Override
                public void onResponse(Call<PersonTvCredits> call, Response<PersonTvCredits> response) {
                    if (response.isSuccessful()) {
                        List<CreditTv> tvs = new ArrayList<>();
                        PersonTvCredits tvCredits = response.body();

                        View cast = LayoutInflater.from(root.getContext()).inflate(R.layout.group_item, null, false);
                        View crew = LayoutInflater.from(root.getContext()).inflate(R.layout.group_item, null, false);

                        TextView castTitle = cast.findViewById(R.id.group_title);
                        TextView crewTitle = crew.findViewById(R.id.group_title);

                        castTitle.setText("CAST");
                        crewTitle.setText("CREW");

                        RecyclerView castRecyclerView = cast.findViewById(R.id.group_recycler_view);
                        RecyclerView crewRecyclerView = crew.findViewById(R.id.group_recycler_view);

                        TvCreditAdapter castAdapter = new TvCreditAdapter(getContext(), tvs);
                        TvCreditAdapter crewAdapter = new TvCreditAdapter(getContext(), tvs);

                        castRecyclerView.setAdapter(castAdapter);
                        crewRecyclerView.setAdapter(crewAdapter);

                        castAdapter.updateData(tvCredits.getCast());
                        crewAdapter.updateData(tvCredits.getCrew());

                        if (tvCredits.getCast().size() != 0 && tvCredits.getCast() != null) {
                            linearLayout.addView(cast);
                        }
                        if (tvCredits.getCrew().size() != 0 && tvCredits.getCrew() != null) {
                            linearLayout.addView(crew);
                        }
                    }
                }

                @Override
                public void onFailure(Call<PersonTvCredits> call, Throwable t) {

                }
            });
        }).start();
    }

    private void getMovieCredits(int id) {
        new Thread(() -> {
            getPeople.getPersonMovieCredits(id).enqueue(new Callback<PersonMovieCredits>() {
                @Override
                public void onResponse(Call<PersonMovieCredits> call, Response<PersonMovieCredits> response) {
                    if (response.isSuccessful()) {
                        List<CreditMovie> movies = new ArrayList<>();
                        PersonMovieCredits movieCredits = response.body();

                        View cast = LayoutInflater.from(root.getContext()).inflate(R.layout.group_item, null, false);
                        View crew = LayoutInflater.from(root.getContext()).inflate(R.layout.group_item, null, false);

                        TextView castTitle = cast.findViewById(R.id.group_title);
                        TextView crewTitle = crew.findViewById(R.id.group_title);

                        castTitle.setText("CAST");
                        crewTitle.setText("CREW");

                        RecyclerView castRecyclerView = cast.findViewById(R.id.group_recycler_view);
                        RecyclerView crewRecyclerView = crew.findViewById(R.id.group_recycler_view);

                        MovieCreditAdapter castAdapter = new MovieCreditAdapter(getContext(), movies);
                        MovieCreditAdapter crewAdapter = new MovieCreditAdapter(getContext(), movies);

                        castRecyclerView.setAdapter(castAdapter);
                        crewRecyclerView.setAdapter(crewAdapter);

                        castAdapter.updateData(movieCredits.getCast());
                        crewAdapter.updateData(movieCredits.getCrew());

                        if (movieCredits.getCast().size() != 0 && movieCredits.getCast() != null) {
                            linearLayout.addView(cast);
                        }
                        if (movieCredits.getCrew().size() != 0 && movieCredits.getCrew() != null) {
                            linearLayout.addView(crew);
                        }
                    }
                }

                @Override
                public void onFailure(Call<PersonMovieCredits> call, Throwable t) {

                }
            });
        }).start();
    }

    private void loadData(int id) {
        new Thread(() -> {
            getPeople.getPerson(id).enqueue(new Callback<Person>() {
                @Override
                public void onResponse(Call<Person> call, Response<Person> response) {
                    if (response.isSuccessful()) {
                        Person person = response.body();
                        actorName.setText(person.getName());
                        placeOfBirth.setText(person.getPlace_of_birth());
//                        popularity.setText(String.valueOf(person.getPopularity()));
                        knownForDepartment.setText(person.getKnown_for_department());
                        birthday.setText(person.getBirthday());
                        biography.setText(person.getBiography());
                        Glide.with(getContext())
                                .load(Constants.POSTER_SRC + person.getProfile_path())
                                .into(picture);
                    }
                }

                @Override
                public void onFailure(Call<Person> call, Throwable t) {

                }
            });
        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        activity.getWindow().clearFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @Override
    public void onPause() {
        super.onPause();
        activity.getWindow().clearFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @Override
    public void onResume() {
        super.onResume();
        activity.getWindow().setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP, Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }
}