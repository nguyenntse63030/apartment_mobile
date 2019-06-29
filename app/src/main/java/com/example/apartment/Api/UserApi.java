package com.example.apartment.Api;

import com.google.gson.JsonElement;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserApi {

    @GET("user/role/{role}")
    Call<JsonElement> getUsersByRole(@Path("role")String role);
    @Headers({
            "Content-Type:application/json"
    })
    @POST("auth/sign_in")
    Call<JsonElement> verify(@Body Map<String,String> data);
}
