package com.squad.filmio;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP, Intent.FLAG_ACTIVITY_CLEAR_TOP);
        setContentView(R.layout.activity_home);


        initBottomBar();
    }

    private void initBottomBar() {
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_movies, R.id.navigation_tv, R.id.navigation_actors
        )
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        try {
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        } catch (Exception e) {
//            Toast.makeText(this, "ActionBar not found", Toast.LENGTH_SHORT).show();
        }
        NavigationUI.setupWithNavController(navView, navController);
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}