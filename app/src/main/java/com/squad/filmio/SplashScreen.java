package com.squad.filmio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private final int TIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        setSplash();
    }

    private void setSplash() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, HomeActivity.class));
        }, TIME);
    }
}