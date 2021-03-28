package com.example.homeservice.api;

import com.example.homeservice.model.login.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface AuthApis {
    @POST("api/Auth/AuthorizeUser")
    Call<LoginResponse> loginUser(@Body Map<String, String> request);

    @POST("api/Register/RegisterUser")
    Call<LoginResponse> registerUser(@Body Map<String, String> request);
}
