package com.example.apartment.Global;

import android.text.format.DateFormat;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GlobalValue {

    public static final int SPINER_LOADING_TIME_OUT = 2000;
    public static FirebaseAuth mAuth;

    public static final Retrofit retrofit=new Retrofit.Builder()
//             .baseUrl("http://172.20.10.2:1998/api/v1/")
            .baseUrl("https://apartmentswd391.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static String getDate(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time);
        String date = DateFormat.format("dd/MM/yyyy", cal).toString();
        return date;
    }
    public static String getTimestamp(String str_date) {
        String timestamp ="";
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = (Date)formatter.parse(str_date);
            long timestampLong=date.getTime();
            timestamp = String.valueOf(timestampLong);

        }catch (Exception e){
            e.printStackTrace();
        }

        return timestamp;
    }

}
