package com.example.homeservice.ui.explore.offer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.homeservice.R;
import com.example.homeservice.api.ExploreApi;
import com.example.homeservice.helper.RetrofitInstance;
import com.example.homeservice.model.offer.OfferResponse;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OffersFragment extends Fragment {
    private RecyclerView rvOffers;
    private ShimmerFrameLayout shimmer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_offers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        uiInit(view);

        offerApiCall();
    }

    private void offerApiCall() {
        shimmer.setVisibility(View.VISIBLE);
        rvOffers.setVisibility(View.GONE);
        ExploreApi apis = RetrofitInstance.getInstance(getContext()).create(ExploreApi.class);
        Call<List<OfferResponse>> call = apis.getOffers();
        call.enqueue(new Callback<List<OfferResponse>>() {
            @Override
            public void onResponse(@NotNull Call<List<OfferResponse>> call, @NotNull Response<List<OfferResponse>> response) {
                shimmer.setVisibility(View.GONE);
                rvOffers.setVisibility(View.VISIBLE);
                try {
                    setUpRecyclerView(response.body());
                } catch (Exception ex) {
                    Toast.makeText(requireContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<OfferResponse>> call, @NotNull Throwable t) {
                shimmer.setVisibility(View.GONE);
                rvOffers.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUpRecyclerView(List<OfferResponse> offers) {
        if (offers != null) {
            rvOffers.setLayoutManager(new LinearLayoutManager(requireContext()));
            rvOffers.setAdapter(new OfferAdapter(offers));
        }
    }

    private void uiInit(View view) {
        rvOffers = view.findViewById(R.id.rvOffer);
        shimmer = view.findViewById(R.id.shimmer);
    }
}