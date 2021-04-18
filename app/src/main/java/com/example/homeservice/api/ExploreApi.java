package com.example.homeservice.api;

import com.example.homeservice.model.offer.OfferResponse;
import com.example.homeservice.model.problem.ProblemResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ExploreApi {
    @GET("api/Offers/")
    Call<List<OfferResponse>> getOffers();

    @GET("api/Problem/")
    Call<List<ProblemResponse>> getProblems();

    @POST("url")
    Call<String> createBooking(@Path("id") int id, @Body OfferResponse data, @Body Map<String, String> body);
}
