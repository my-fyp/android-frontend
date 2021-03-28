package com.example.homeservice.ui.project.booking;

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
import com.example.homeservice.ui.explore.offer.OfferAdapter;

import dummydata.DummyData;


public class BookingFragment extends Fragment {
    private RecyclerView rvBooking;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_booking, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        uiInit(view);
        DummyData.populateOffer();

        rvBooking.setLayoutManager(new LinearLayoutManager(requireContext()));
        //rvBooking.setAdapter(new OfferAdapter(OfferService.offers));
    }

    private void uiInit(View view) {
    }

}