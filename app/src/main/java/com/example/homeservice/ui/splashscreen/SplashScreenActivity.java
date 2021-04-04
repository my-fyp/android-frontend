package com.example.homeservice.ui.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.homeservice.R;
import com.example.homeservice.helper.Prefs;
import com.example.homeservice.ui.auth.register.ContactActivity;
import com.example.homeservice.ui.dashboard.DashboardActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (Prefs.getIsLoggedIn()) {
                    startActivity(new Intent(SplashScreenActivity.this, DashboardActivity.class));
                } else {
                    startActivity(new Intent(SplashScreenActivity.this, ContactActivity.class));
                }
                finish();
            }
        }, 3000);
    }
}