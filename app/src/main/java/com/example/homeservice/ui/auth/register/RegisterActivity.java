package com.example.homeservice.ui.auth.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.homeservice.R;
import com.example.homeservice.api.AuthApis;
import com.example.homeservice.helper.RetrofitInstance;
import com.example.homeservice.model.login.LoginResponse;
import com.example.homeservice.ui.auth.login.LoginActivity;
import com.example.homeservice.ui.dashboard.DashboardActivity;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private RadioButton btn1;
    private RadioButton btn2;
    private Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn1 = (RadioButton) findViewById(R.id.radioCustomer);
        btn2 = (RadioButton) findViewById(R.id.radioVendor);
        register = (Button) findViewById(R.id.btn_register);

        register.setOnClickListener(v -> {
            Map<String, String> request = new HashMap<>();
            request.put("username", "");
            request.put("password", "");
            request.put("name", "");
            request.put("phoneNo", "");
            request.put("address", "");
            request.put("gender", "");
            request.put("userType", "");

            AuthApis api = RetrofitInstance.getInstance().create(AuthApis.class);

            Call<LoginResponse> call = api.registerUser(request);
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    try {
                        String name = response.body().getResult().getName();
                        Toast.makeText(RegisterActivity.this, name, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, DashboardActivity.class));
                        finish();
                    } catch (Exception ex) {
                        Toast.makeText(RegisterActivity.this, "Invalid user", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}