package com.example.homeservice;

import android.app.Application;
import android.content.SharedPreferences;

public class MyApp extends Application {
    private static final String HomeSewa = "Shared.homesewa";
    public static SharedPreferences sharedPrefs;
    @Override
    public void onCreate() {
        super.onCreate();
        sharedPrefs = getSharedPreferences(HomeSewa, MODE_PRIVATE);
    }
}
