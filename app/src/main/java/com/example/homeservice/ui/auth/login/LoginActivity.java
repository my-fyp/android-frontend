package com.example.homeservice.ui.auth.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.homeservice.api.AuthApis;
import com.example.homeservice.databinding.ActivityLoginBinding;
import com.example.homeservice.helper.RetrofitInstance;
import com.example.homeservice.model.login.LoginResponse;
import com.example.homeservice.ui.auth.register.ContactActivity;
import com.example.homeservice.ui.dashboard.DashboardActivity;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.ivBack.setOnClickListener(v -> onBackPressed());

        binding.btnSignUp.setOnClickListener(v -> {
            startActivity(new Intent(this, ContactActivity.class));
        });

        onLogin();
    }

    private void onLogin() {
        binding.btnSignIn.setOnClickListener(v -> {

            Map<String, String> request = new HashMap<>();
            request.put("username", binding.etContact.getText().toString());
            request.put("password", binding.etPassword.getText().toString());

            AuthApis api = RetrofitInstance.getInstance().create(AuthApis.class);

            Call<LoginResponse> call = api.loginUser(request);
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    try {
                        String name = response.body().getResult().getName();
                        Toast.makeText(LoginActivity.this, name, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                        finish();
                    } catch (Exception ex) {
                        Toast.makeText(LoginActivity.this, "Invalid user", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}