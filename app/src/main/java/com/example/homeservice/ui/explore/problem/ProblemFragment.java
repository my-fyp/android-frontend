package com.example.homeservice.ui.explore.problem;

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
import com.example.homeservice.service.ProblemService;

import dummydata.DummyData;

public class ProblemFragment extends Fragment {
    private RecyclerView rvProblem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_problem, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        uiInit(view);
        DummyData.populateProblem();

        rvProblem.setLayoutManager(new LinearLayoutManager(requireContext()));
        rvProblem.setAdapter(new ProblemAdapter(ProblemService.problems));
    }

    private void uiInit(View view) {
        rvProblem = view.findViewById(R.id.rvProblem);
    }
}