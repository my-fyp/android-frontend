package com.example.homeservice.ui.auth.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.homeservice.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.ivBack).setOnClickListener(v -> onBackPressed());
    }
}