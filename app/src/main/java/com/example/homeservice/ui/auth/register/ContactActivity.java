package com.example.homeservice.ui.auth.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.homeservice.Constants;
import com.example.homeservice.R;
import com.example.homeservice.databinding.ActivityContactBinding;
import com.example.homeservice.ui.auth.login.LoginActivity;

public class ContactActivity extends AppCompatActivity {
    private ActivityContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnContinue.setOnClickListener(v -> {
            Intent intent = new Intent(ContactActivity.this, OtpCodeActivity.class);
            intent.putExtra(Constants.Contact, binding.etPhoneNumber.getText().toString());
            startActivity(intent);
        });
        binding.btnLogin.setOnClickListener(v -> startActivity(new Intent(ContactActivity.this, LoginActivity.class)));
    }
}