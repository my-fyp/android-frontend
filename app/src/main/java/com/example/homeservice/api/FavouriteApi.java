package com.example.homeservice.api;

import com.example.homeservice.model.fav.FavResponse;
import com.example.homeservice.ui.project.request.RequestAdapter;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FavouriteApi {
    @GET("/api/Favourite/GetFavorites/{userId}")
    Call<List<FavResponse>>getFavorites (@Path("userId") int userId);

    @POST("/api/Favourite")
    Call<FavResponse> Favourite(@Body Map<Integer,Integer>request);

    @DELETE("/api/Favourite/DeleteFavourites/{FavouriteId}")
    Call<List<FavResponse>> DeletFavorites(@Path("FavouriteId") int FavouriteId);

}
