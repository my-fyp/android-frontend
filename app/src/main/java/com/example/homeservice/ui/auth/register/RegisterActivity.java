package com.example.homeservice.ui.auth.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.homeservice.R;

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

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(), NavDrawer.class);
                //startActivity(intent);\
            }
        });
    }
}