package com.example.homeservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        findViewById(R.id.btnContinue).setOnClickListener(v ->
                startActivity(new Intent(ContactActivity.this, OtpCodeActivity.class))
        );
        findViewById(R.id.btnLogin).setOnClickListener(v -> startActivity(new Intent(ContactActivity.this, LoginActivity.class)));
    }
}