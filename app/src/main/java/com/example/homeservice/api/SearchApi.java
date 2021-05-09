package com.example.homeservice.api;

import com.example.homeservice.model.search.ServiceResponse;
import com.example.homeservice.model.specialist.SpecialistResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SearchApi {
    @GET("api/Search/")
    Call<List<ServiceResponse>> GetServices(@Query("searchItem") String searchItem);

    @GET("api/Search/GetSpecialist/{slug}/")
    Call<List<SpecialistResponse>> GetSpecialist(@Path("slug") String slug);
}
