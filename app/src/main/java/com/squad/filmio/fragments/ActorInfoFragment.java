package com.squad.filmio.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.squad.filmio.Constants;
import com.squad.filmio.R;
import com.squad.filmio.api.methods.GetPeople;
import com.squad.filmio.api.models.person.Person;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActorInfoFragment extends Fragment {
    private View root;
    private Activity activity;
    private ImageView picture;
    private TextView actorName, placeOfBirth, popularity, birthday, biography;
    private int id;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_actor_info, container, false);
        activity = (AppCompatActivity) root.getContext();
        activity.getWindow().setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP, Intent.FLAG_ACTIVITY_CLEAR_TOP);

        picture = root.findViewById(R.id.actors_info_picture);
        actorName = root.findViewById(R.id.actor_info_actor_name);
        placeOfBirth = root.findViewById(R.id.actor_info_place_of_birth);
        popularity = root.findViewById(R.id.actor_info_popularity);
        birthday = root.findViewById(R.id.actor_info_birthday);
        biography = root.findViewById(R.id.actor_info_biography);

        Bundle args = getArguments();
        id = args.getInt("actorId", 0);
        loadData(id);
        return root;
    }

    private void loadData(int id) {
        new Thread(() -> {
            new GetPeople().getPerson(id).enqueue(new Callback<Person>() {
                @Override
                public void onResponse(Call<Person> call, Response<Person> response) {
                    if (response.isSuccessful()) {
                        Person person = response.body();
                        actorName.setText(person.getName());
                        placeOfBirth.setText(person.getPlace_of_birth());
                        popularity.setText(String.valueOf(person.getPopularity()));
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