package com.example.homeservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class OtpCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_code);
        findViewById(R.id.tvPin).requestFocus();
        findViewById(R.id.btnVerify).setOnClickListener(v -> startActivity(new Intent(OtpCodeActivity.this, RegisterActivity.class)));
    }
}