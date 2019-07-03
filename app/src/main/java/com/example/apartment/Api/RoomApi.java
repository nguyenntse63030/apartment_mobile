package com.example.apartment.Api;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RoomApi {
    @GET("room/userId/{userId}")
    Call<JsonElement> getRoomByUser(@Path("userId")String userId);
}
