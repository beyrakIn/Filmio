package com.squad.filmio.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squad.filmio.Constants;
import com.squad.filmio.R;
import com.squad.filmio.api.methods.GetPeople;
import com.squad.filmio.api.models.movie.Film;
import com.squad.filmio.api.models.person.Person;
import com.squad.filmio.api.models.person.PersonMovieCredits;
import com.squad.filmio.api.models.person.PersonTvCredit;
import com.squad.filmio.ui.adapters.FilmAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActorInfoFragment extends Fragment {
    private View root;
    private Activity activity;
    private LinearLayout linearLayout;
    private RelativeLayout loader;
    private ImageView picture;
    private TextView actorName, placeOfBirth, popularity, birthday, biography, knownForDepartment;
    private int personId;
    private final GetPeople getPeople = new GetPeople();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_actor_info, container, false);
        activity = (AppCompatActivity) root.getContext();
        activity.getWindow().setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP, Intent.FLAG_ACTIVITY_CLEAR_TOP);

        linearLayout = root.findViewById(R.id.actor_info_main_linear);
        loader = root.findViewById(R.id.relative_loader);
        picture = root.findViewById(R.id.actors_info_picture);
        actorName = root.findViewById(R.id.actor_info_actor_name);
        placeOfBirth = root.findViewById(R.id.actor_info_place_of_birth);
//        popularity = root.findViewById(R.id.actor_info_popularity);
        knownForDepartment = root.findViewById(R.id.actor_info_known_for_department);
        birthday = root.findViewById(R.id.actor_info_birthday);
        biography = root.findViewById(R.id.actor_info_biography);

        Bundle args = getArguments();
        assert args != null;
        personId = args.getInt("actorId", 0);
        loadData(personId);
        getMovieCredits(personId);
        getTvCredits(personId);
        return root;
    }

    private void getTvCredits(int id) {
        new Thread(() -> {
            getPeople.getPersonTvCredits(id).enqueue(new Callback<PersonTvCredit>() {
                @Override
                public void onResponse(Call<PersonTvCredit> call, Response<PersonTvCredit> response) {
                    if (response.isSuccessful()) {
                        List<Film> tvs = new ArrayList<>();
                        PersonTvCredit tvCredits = response.body();

                        View cast = LayoutInflater.from(root.getContext()).inflate(R.layout.group_item, null, false);
                        View crew = LayoutInflater.from(root.getContext()).inflate(R.layout.group_item, null, false);

                        TextView castTitle = cast.findViewById(R.id.group_title);
                        TextView crewTitle = crew.findViewById(R.id.group_title);

                        castTitle.setText("TV SHOWS");
                        crewTitle.setText("TV SHOWS");

                        RecyclerView castRecyclerView = cast.findViewById(R.id.group_recycler_view);
                        RecyclerView crewRecyclerView = crew.findViewById(R.id.group_recycler_view);

                        FilmAdapter castAdapter = new FilmAdapter(getContext(), tvs,
                                R.id.action_actorInfoFragment_to_movieDetailsFragment, false);
                        FilmAdapter crewAdapter = new FilmAdapter(getContext(), tvs,
                                R.id.action_actorInfoFragment_to_movieDetailsFragment, false);

                        castRecyclerView.setAdapter(castAdapter);
                        crewRecyclerView.setAdapter(crewAdapter);

//                        Film casts = (Film) tvCredits.getCast();
                        castAdapter.updateData(tvCredits.getCast());
                        crewAdapter.updateData(tvCredits.getCrew());

                        if (tvCredits.getCast().size() != 0 && tvCredits.getCast() != null) {
                            linearLayout.addView(cast);
                        }
                        if (tvCredits.getCrew().size() != 0 && tvCredits.getCrew() != null) {
                            linearLayout.addView(crew);
                        }

//                        if (loader.getVisibility() == View.VISIBLE){
//                            loader.removeAllViewsInLayout();
//                            loader.setVisibility(View.GONE);
//                        }
                    }
                }

                @Override
                public void onFailure(Call<PersonTvCredit> call, Throwable t) {

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
                        List<Film> movies = new ArrayList<>();
                        PersonMovieCredits movieCredits = response.body();

                        View cast = LayoutInflater.from(root.getContext()).inflate(R.layout.group_item, null, false);
                        View crew = LayoutInflater.from(root.getContext()).inflate(R.layout.group_item, null, false);

                        TextView castTitle = cast.findViewById(R.id.group_title);
                        TextView crewTitle = crew.findViewById(R.id.group_title);

                        castTitle.setText("MOVIES");
                        crewTitle.setText("MOVIES");

                        RecyclerView castRecyclerView = cast.findViewById(R.id.group_recycler_view);
                        RecyclerView crewRecyclerView = crew.findViewById(R.id.group_recycler_view);

                        FilmAdapter castAdapter = new FilmAdapter(getContext(), movies,
                                R.id.action_actorInfoFragment_to_movieDetailsFragment, true);
                        FilmAdapter crewAdapter = new FilmAdapter(getContext(), movies,
                                R.id.action_actorInfoFragment_to_movieDetailsFragment, true);


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

//                        if (loader.getVisibility() == View.VISIBLE){
//                            loader.removeAllViewsInLayout();
//                            loader.setVisibility(View.GONE);
//                        }
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

                        if (loader.getVisibility() == View.VISIBLE) {
                            loader.removeAllViewsInLayout();
                            loader.setVisibility(View.GONE);
                        }
                    }
                }

                @Override
                public void onFailure(Call<Person> call, Throwable t) {
                    new Handler().postDelayed(() -> {
                        loadData(personId);
                    }, 5000);
                }
            });
        }).start();
    }
}