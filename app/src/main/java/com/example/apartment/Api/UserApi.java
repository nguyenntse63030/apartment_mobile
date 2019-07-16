package com.example.apartment.Api;

import com.google.gson.JsonElement;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserApi {

    @GET("user/role/{role}")
    Call<JsonElement> getUsersByRole(@Path("role")String role);
    @Headers({
            "Content-Type:application/json"
    })
    @POST("auth/sign_in_mobile")
    Call<JsonElement> verify(@Body Map<String,String> data);
//    https://apartmentswd391.herokuapp.com/api/v1/auth/google
    @Headers({
            "Content-Type:application/json"
    })
    @POST("auth/verifyGoogle")
    Call<JsonElement> verifyGoogle(@Body Map<String,String> data);
    @Headers({
            "Content-Type:application/json"
    })
    @PUT("user/{userId}")
    Call<JsonElement> updateUser(@Header("mobile-access-token") String token,@Path("userId")String userId,@Body Map<String,String> data);
    @PUT("user/deposit")
    Call<JsonElement> depositAccount(@Header("mobile-access-token") String token,@Body Map<String,String> data);
}
