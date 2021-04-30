package com.squad.filmio;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private final int TIME = 1000;
    static int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        setSplash();
    }

    private void setSplash() {
        new Handler().postDelayed(() -> {
        }, TIME);
    }
}