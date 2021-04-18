package com.example.homeservice.api;

import com.example.homeservice.model.bookingreq.BookingResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BookingApi {
    @GET("api/Booking/GetBookingRequests/{userId}/{userType}/")
    Call<List<BookingResponse>> getBookingRequests(@Path("userId") int userId, @Path("userType") String userType);

    @GET("/api/Booking/GetBookings/{userId}/{userType}/{completedStatus}")
    Call<List<BookingResponse>> getBookings(
            @Path("userId") int userId,
            @Path("userType") String userType,
            @Path("completedStatus") Boolean completedStatus
    );
}
