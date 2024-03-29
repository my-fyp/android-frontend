package com.example.homeservice.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProjectApis {
    @GET("api/Booking/GetBookings/{userId}/{userType}/{completedStatus}")
    Call<List<String>> getBookings(@Path("userId") int userId,
                                   @Path("userType") String userType,
                                   @Path("completedStatus") Boolean status);

    @GET("/api/Booking/GetBookingRequests/{userId}/{userType}")
    Call<List<String>> getBookingRequests(@Path("userId")int userId,
                                          @Path("userType") String userType);

   /* @POST("/api/Booking/MakeBookingRequest")
    Call<List> makeBookingRequest(@Path())*/

    


}
