package com.example.homeservice.ui.specialists;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeservice.Constants;
import com.example.homeservice.R;
import com.example.homeservice.api.SearchApi;
import com.example.homeservice.helper.RetrofitInstance;
import com.example.homeservice.model.specialist.SpecialistResponse;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.homeservice.Constants.SpecialitySlug;

public class SpecialistActivity extends AppCompatActivity {
    private RecyclerView rvSpecialists;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialist);
        Objects.requireNonNull(getSupportActionBar()).setTitle(getServiceType());

        initView();
        specialistApiCall(getSlug());
    }

    private void initView() {
        rvSpecialists = findViewById(R.id.rvSpecialists);
    }

    private void specialistApiCall(String slug) {
        try {
            SearchApi searchApi = RetrofitInstance.getInstance(this).create(SearchApi.class);
            Call<List<SpecialistResponse>> response = searchApi.GetSpecialist(slug);

            response.enqueue(new Callback<List<SpecialistResponse>>() {
                @Override
                public void onResponse(@NotNull Call<List<SpecialistResponse>> call, @NotNull Response<List<SpecialistResponse>> response) {
                    if (response.body() == null) return;
                    initRecyclerView(response.body());
                }

                @Override
                public void onFailure(@NotNull Call<List<SpecialistResponse>> call, @NotNull Throwable t) {
                    Toast.makeText(SpecialistActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception ex) {
            Log.e("ExceptionSpecialist", ex.getMessage());
        }
    }

    private void initRecyclerView(List<SpecialistResponse> response) {
        rvSpecialists.setLayoutManager(new LinearLayoutManager(this));
        rvSpecialists.setAdapter(new SpecialistAdapter(response, getServiceType()));
    }

    private String getSlug() {
        return getIntent().getStringExtra(SpecialitySlug);
    }

    private String getServiceType() {
        return getIntent().getStringExtra(Constants.ServiceType);
    }
}
