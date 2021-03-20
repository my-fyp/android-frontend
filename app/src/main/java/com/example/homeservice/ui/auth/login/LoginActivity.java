package com.example.homeservice.ui.auth.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.homeservice.R;
import com.example.homeservice.ui.auth.register.ContactActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.ivBack).setOnClickListener(v -> onBackPressed());

        findViewById(R.id.btnSignUp).setOnClickListener(v -> {
            startActivity(new Intent(this, ContactActivity.class));
        });
    }
}