package com.example.homeservice.api;

import com.example.homeservice.model.offer.OfferResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ExploreApi {
    @GET("api/Offers/")
    Call<List<OfferResponse>> getOffers();
}
