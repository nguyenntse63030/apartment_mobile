package com.example.apartment.Global;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GlobalValue {

    public static final int SPINER_LOADING_TIME_OUT = 2000;
    public static final Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("https://apartmentswd391.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
