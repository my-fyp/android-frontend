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

import com.example.homeservice.R;
import com.example.homeservice.service.OfferService;

import dummydata.DummyData;

public class OffersFragment extends Fragment {
    private RecyclerView rvOffers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_offers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        uiInit(view);
        DummyData.populateOffer();

        rvOffers.setLayoutManager(new LinearLayoutManager(requireContext()));
        rvOffers.setAdapter(new OfferAdapter(OfferService.offers));
    }

    private void uiInit(View view) {
        rvOffers = view.findViewById(R.id.rvOffer);
    }
}