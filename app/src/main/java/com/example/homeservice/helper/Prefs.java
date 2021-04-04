package com.example.homeservice.helper;

import android.content.SharedPreferences;

import com.example.homeservice.MyApp;
import com.example.homeservice.model.login.LoginResult;
import com.google.gson.Gson;

public class Prefs {
    private static final String isLoggedIn = "Shared.isLoggedIn";
    private static final String profileDetails = "Shared.profileDetails";
    private static final SharedPreferences.Editor editor = MyApp.sharedPrefs.edit();

    public static void setIsLoggedIn(){
        editor.putBoolean(isLoggedIn, true);
        editor.commit();
    }

    public static boolean getIsLoggedIn(){
        return MyApp.sharedPrefs.getBoolean(isLoggedIn, false);
    }

    public static void setProfileDetails(LoginResult result){
        Gson gson = new Gson();
        String loginResult = gson.toJson(result);
        editor.putString(profileDetails, loginResult);
        editor.commit();
    }

    public static LoginResult getProfileDetails(){
        String jsonData = MyApp.sharedPrefs.getString(profileDetails, null);
        Gson gson = new Gson();
        return gson.fromJson(jsonData, LoginResult.class);
    }


    public static void logOut(){
        editor.clear();
        editor.commit();
    }
}
