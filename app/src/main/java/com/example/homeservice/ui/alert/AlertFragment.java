package com.example.homeservice.ui.alert;

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
import com.example.homeservice.service.NotificationService;

import dummydata.DummyData;


public class AlertFragment extends Fragment {
    private RecyclerView rvNotification;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alert, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DummyData.populateNotification();
        uiInit(view);
        setupAdapter();
    }

    private void setupAdapter() {
        rvNotification.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNotification.setAdapter(new AlertAdapter(NotificationService.notifications));
    }

    private void uiInit(View view) {
        rvNotification = view.findViewById(R.id.rvNotification);
    }
}