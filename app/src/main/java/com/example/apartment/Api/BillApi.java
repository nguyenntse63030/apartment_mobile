package com.example.apartment.Api;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BillApi {
    @GET("bill/user/unpaid/{userId}")
    Call<JsonElement> getUnpaidBill(@Header("mobile-access-token") String token,@Path("userId")String userId);

    @GET("bill/user/paid/{userId}")
    Call<JsonElement> getPaidBill(@Header("mobile-access-token") String token,@Path("userId")String userId);

    @GET("bill/room/{roomId}")
    Call<JsonElement> getBillByRoom(@Header("mobile-access-token") String token,@Path("roomId")String roomId);

    @PUT("bill/payment/{billId}")
    Call<JsonElement> payBill(@Header("mobile-access-token") String token,@Path("billId") String billId);
}
