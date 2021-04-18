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
import android.widget.Toast;

import com.example.homeservice.R;
import com.example.homeservice.api.ExploreApi;
import com.example.homeservice.helper.RetrofitInstance;
import com.example.homeservice.model.problem.ProblemResponse;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProblemFragment extends Fragment {
    private RecyclerView rvProblem;
    private ShimmerFrameLayout shimmer;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_problem, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        uiInit(view);

        problemAPiCall();
        /*DummyData.populateProblem();

        rvProblem.setLayoutManager(new LinearLayoutManager(requireContext()));
        rvProblem.setAdapter(new ProblemAdapter(ProblemService.problems));*/
    }

    private void problemAPiCall() {
        shimmer.setVisibility(View.VISIBLE);
        ExploreApi apis= RetrofitInstance.getInstance(getContext()).create(ExploreApi.class);
        Call<List<ProblemResponse>> call = apis.getProblems();
        call.enqueue(new Callback<List<ProblemResponse>>() {

            public void onResponse(@NotNull Call<List<ProblemResponse>> call, @NotNull Response<List<ProblemResponse>> response) {
                shimmer.setVisibility(View.GONE);
                rvProblem.setVisibility(View.VISIBLE);
                try {
                    setUpRecyclerView(response.body());
                } catch (Exception ex) {
                    Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ProblemResponse>> call, Throwable t) {
                shimmer.setVisibility(View.GONE);
                rvProblem.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUpRecyclerView(List<ProblemResponse> problems){
        if (problems !=null) {
        rvProblem.setLayoutManager(new LinearLayoutManager(requireContext()));
        rvProblem.setAdapter(new ProblemAdapter(problems));

        }
    }

    private void uiInit(View view) {
        rvProblem = view.findViewById(R.id.rvProblem);
        shimmer = view.findViewById(R.id.shimmer);

    }
}