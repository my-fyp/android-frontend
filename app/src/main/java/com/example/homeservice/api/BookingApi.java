package com.example.homeservice.api;

import com.example.homeservice.MyApp;
import com.example.homeservice.model.bookingreq.BookingResponse;
import com.example.homeservice.model.login.LoginResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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
    @POST("/api/Booking/MakeBookingRequest/")
    Call<BookingResponse> BOOKING_RESPONSE_CALL(@Body Map<String,String > request);

    @PUT("/api/Booking/UpdateBooking/{bookingId}")
    Call<BookingResponse> BOOKING_RESPONSE_PUT(@Body Map<Integer,Integer> request);



}
