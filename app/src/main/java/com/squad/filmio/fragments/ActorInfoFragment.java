package com.squad.filmio.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.squad.filmio.R;


public class ActorInfoFragment extends Fragment {
    private View root;
    private Activity activity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_actor_info, container, false);
        activity = (AppCompatActivity) root.getContext();
        activity.getWindow().setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP, Intent.FLAG_ACTIVITY_CLEAR_TOP);


        return root;
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