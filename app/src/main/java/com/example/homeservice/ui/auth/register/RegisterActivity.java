package com.example.homeservice.ui.auth.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.homeservice.Constants;
import com.example.homeservice.R;
import com.example.homeservice.api.AuthApis;
import com.example.homeservice.databinding.ActivityLoginBinding;
import com.example.homeservice.databinding.ActivityRegisterBinding;
import com.example.homeservice.helper.Prefs;
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

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rbMale.setChecked(true);

        onRadioBtnChange();
        binding.btnRegister.setOnClickListener(v -> {
            int selectedGenderId = binding.rbgParent.getCheckedRadioButtonId();
            RadioButton radioButton = findViewById(selectedGenderId);

            Map<String, String> request = new HashMap<>();
            request.put("username", getContact());
            request.put("password", binding.etPassword.getText().toString());
            request.put("name", binding.etFullName.getText().toString());
            request.put("phoneNo", getContact());
            request.put("address", binding.etAddress.getText().toString());
            request.put("gender", radioButton.getText().toString());
            request.put("userType", getUserType());

            AuthApis api = RetrofitInstance.getInstance(this).create(AuthApis.class);

            Call<LoginResponse> call = api.registerUser(request);
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    try {
                        Prefs.setIsLoggedIn();
                        Prefs.setProfileDetails(response.body().getLoginResult());

                        Intent intent = new Intent(RegisterActivity.this, DashboardActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
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

    private String getUserType() {
        return getIntent().getStringExtra(Constants.UserType);
    }

    private String getContact() {
        return getIntent().getStringExtra(Constants.Contact);
    }

    private void onRadioBtnChange() {
        binding.rbgParent.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbMale) {
                binding.rbMale.setBackgroundResource(R.drawable.radio_selected_bg);
                binding.rbFemale.setBackgroundResource(R.drawable.radio_bg);
                binding.rbOther.setBackgroundResource(R.drawable.radio_bg);
            } else if (checkedId == R.id.rbFemale) {
                binding.rbFemale.setBackgroundResource(R.drawable.radio_selected_bg);
                binding.rbMale.setBackgroundResource(R.drawable.radio_bg);
                binding.rbOther.setBackgroundResource(R.drawable.radio_bg);
            } else {
                binding.rbOther.setBackgroundResource(R.drawable.radio_selected_bg);
                binding.rbFemale.setBackgroundResource(R.drawable.radio_bg);
                binding.rbMale.setBackgroundResource(R.drawable.radio_bg);
            }
        });
    }
}