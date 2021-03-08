package com.example.homeservice.ui.auth.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.homeservice.R;

public class OtpCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_code);
        findViewById(R.id.tvPin).requestFocus();
        findViewById(R.id.btnVerify).setOnClickListener(v -> startActivity(new Intent(OtpCodeActivity.this, RegisterActivity.class)));
    }
}