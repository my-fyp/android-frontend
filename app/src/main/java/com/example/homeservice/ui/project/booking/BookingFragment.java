package com.example.homeservice.ui.project.booking;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.homeservice.R;
import com.example.homeservice.api.BookingApi;
import com.example.homeservice.helper.Prefs;
import com.example.homeservice.helper.RetrofitInstance;
import com.example.homeservice.model.bookingreq.BookingResponse;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BookingFragment extends Fragment {
    private RecyclerView rvBooking;
    private SwipeRefreshLayout refreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_booking, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        uiInit(view);
        bookingsApiCall();

        refreshLayout.setOnRefreshListener(this::bookingsApiCall);
    }

    private void bookingsApiCall() {
        BookingApi api = RetrofitInstance.getInstance(getContext()).create(BookingApi.class);
        Call<List<BookingResponse>> call = api.getBookings(
                Prefs.getProfileDetails().getAccessId(),
                Prefs.getProfileDetails().getUserType(),
                false
        );

        call.enqueue(new Callback<List<BookingResponse>>() {
            @Override
            public void onResponse(@NotNull Call<List<BookingResponse>> call, @NotNull Response<List<BookingResponse>> response) {
                refreshLayout.setRefreshing(false);
                try {
                    populateRecyclerView(response.body());
                } catch (Exception ex) {
                    Log.e("Logger Error", ex.getMessage());
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<BookingResponse>> call, @NotNull Throwable t) {
                refreshLayout.setRefreshing(false);
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateRecyclerView(List<BookingResponse> response) {
        if (response != null) {
            rvBooking.setLayoutManager(new LinearLayoutManager(getContext()));
            BookingAdapter adapter = new BookingAdapter(response);
            rvBooking.setAdapter(adapter);
        }
    }

    private void uiInit(View view) {
        rvBooking = view.findViewById(R.id.rvBooking);
        refreshLayout = view.findViewById(R.id.refresh);
    }
}