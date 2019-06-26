package com.example.apartment.Api;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApi {
    @GET("user/role/{role}")
    Call<JsonElement> getUsersByRole(@Path("role")String role);
}
