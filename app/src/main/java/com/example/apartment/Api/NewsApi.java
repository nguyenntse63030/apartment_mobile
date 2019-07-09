package com.example.apartment.Api;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface NewsApi {
    @GET("news/")
    Call<JsonElement> getNews(@Header("mobile-access-token") String token);
}
