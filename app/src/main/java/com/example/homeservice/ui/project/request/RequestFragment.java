package com.example.homeservice.ui.project.request;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.homeservice.R;
import com.example.homeservice.api.BookingApi;
import com.example.homeservice.helper.Prefs;
import com.example.homeservice.helper.RetrofitInstance;
import com.example.homeservice.model.bookingreq.BookingResponse;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RequestFragment extends Fragment {
    private RecyclerView rvRequest;
    private ShimmerFrameLayout shimmer;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        uiInit(view);

        BookingRequestApiCall();
    }

    private void BookingRequestApiCall() {
        try {
            shimmer.setVisibility(View.VISIBLE);
            rvRequest.setVisibility(View.GONE);
            BookingApi bookingApi = RetrofitInstance.getInstance(getContext()).create(BookingApi.class);
            Call<List<BookingResponse>> call = bookingApi.getBookingRequests(Prefs.getProfileDetails().getAccessId(), Prefs.getProfileDetails().getUserType());
            call.enqueue(new Callback<List<BookingResponse>>() {
                @Override
                public void onResponse(@NotNull Call<List<BookingResponse>> call, @NotNull Response<List<BookingResponse>> response) {
                    shimmer.setVisibility(View.GONE);
                    rvRequest.setVisibility(View.VISIBLE);
                    try {
                        populateRecyclerView(response.body());
                    } catch (Exception ex) {
                        Log.e("ResponseTag", ex.getMessage());
                    }
                }

                @Override
                public void onFailure(@NotNull Call<List<BookingResponse>> call, @NotNull Throwable t) {
                    shimmer.setVisibility(View.GONE);
                    rvRequest.setVisibility(View.VISIBLE);
                    Toast.makeText(getContext(), "Error Message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception ex) {
            Log.e("ExceptionRequest", ex.getMessage());
        }
    }

    private void populateRecyclerView(List<BookingResponse> bookingRequests) {
        if (bookingRequests != null) {
            rvRequest.setLayoutManager(new LinearLayoutManager(getContext()));
            RequestAdapter requestAdapter = new RequestAdapter(bookingRequests);
            rvRequest.setAdapter(requestAdapter);
        }
    }

    private void uiInit(View view) {
        rvRequest = view.findViewById((R.id.rvRequest));
        shimmer = view.findViewById(R.id.shimmer);
    }

}