package com.example.homeservice.ui.search;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeservice.R;
import com.example.homeservice.api.SearchApi;
import com.example.homeservice.helper.RetrofitInstance;
import com.example.homeservice.model.search.ServiceResponse;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {
    RecyclerView feature_recycler;
    private RelativeLayout searchItem;
    private RecyclerView rvServices;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

        searchItem.setOnClickListener(v -> {

        });
        servicesApiCall();
    }

    private void servicesApiCall() {
        try {
            SearchApi searchApi = RetrofitInstance.getInstance(getContext()).create(SearchApi.class);
            Call<List<ServiceResponse>> services = searchApi.GetServices("");
            services.enqueue(new Callback<List<ServiceResponse>>() {
                @Override
                public void onResponse(@NotNull Call<List<ServiceResponse>> call, @NotNull Response<List<ServiceResponse>> response) {
                    if (response.body() == null) return;
                    initRecyclerView(response.body());
                }

                @Override
                public void onFailure(@NotNull Call<List<ServiceResponse>> call, @NotNull Throwable t) {
                    Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception ex) {
            Log.e("SearchException", ex.getMessage());
        }
    }

    private void initRecyclerView(List<ServiceResponse> services) {
        rvServices.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rvServices.setAdapter(new ServiceAdapter(services));
    }

    private void initView(View view) {
        searchItem = view.findViewById(R.id.rlSearchItem);
        rvServices = view.findViewById(R.id.rvServices);
    }
}
