package com.example.homeservice.api;

import com.example.homeservice.model.offer.OfferResponse;
import com.example.homeservice.model.problem.ProblemResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ExploreApi {
    @GET("api/Offers/")
    Call<List<OfferResponse>> getOffers();

    @GET("api/Problem/")
    Call<List<ProblemResponse>> getProblems();

    @POST("url")
    Call<String> createBooking(@Path("id") int id, @Body OfferResponse data, @Body Map<String, String> body);

    @PUT("/api/Offers/UpdateOffer/{OfferId}")
    Call<POST> putPost(@Path("Offerid") int OfferId,@Body OfferResponse post);

    @PATCH("/api/Offers/UpdateOffer/{OfferId}")
    Call<POST> patchPost(@Path("OfferId") int OfferId,@Body OfferResponse post);

}
