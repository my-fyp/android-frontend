package com.example.homeservice.ui.auth.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.homeservice.Constants;
import com.example.homeservice.R;

public class UserTypeActivity extends AppCompatActivity {
    private TextView customer;
    private TextView serviceProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);
        initUi();

        onCustomerClick();
        onVendorClick();
    }

    private void onCustomerClick() {
        customer.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            intent.putExtra(Constants.UserType, Constants.CUSTOMER);
            intent.putExtra(Constants.Contact, getContact());
            startActivity(intent);
        });
    }

    private void onVendorClick() {
        serviceProvider.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            intent.putExtra(Constants.UserType, Constants.VENDOR);
            intent.putExtra(Constants.Contact, getContact());
            startActivity(intent);
        });
    }

    private void initUi() {
        customer = findViewById(R.id.customer);
        serviceProvider = findViewById(R.id.serviceProvider);
    }

    private String getContact() {
        return getIntent().getStringExtra(Constants.Contact);
    }
}