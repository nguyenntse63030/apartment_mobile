package com.example.apartment.Api;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface BillApi {
    @GET("bill/user/unpaid/{userId}")
    Call<JsonElement> getUnpaidBill(@Path("userId")String userId);

    @GET("bill/user/paid/{userId}")
    Call<JsonElement> getPaidBill(@Path("userId")String userId);

    @GET("bill/room/{roomId}")
    Call<JsonElement> getBillByRoom(@Path("roomId")String roomId);
}
