package com.squad.filmio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.squad.filmio.api.methods.GetMovies;
import com.squad.filmio.api.models.discover.Discover;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}