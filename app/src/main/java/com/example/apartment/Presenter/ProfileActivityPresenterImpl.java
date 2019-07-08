package com.example.apartment.Presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.apartment.Contract.ProfileActivityContract;
import com.example.apartment.Global.GlobalValue;
import com.makeramen.roundedimageview.RoundedImageView;

public class ProfileActivityPresenterImpl implements ProfileActivityContract.ProfileActivityPresenter {
    @Override
    public void fillData(RoundedImageView imgAvatar,TextView txtFullName,TextView txtGendar,TextView txtPhone,
                         TextView txtEmail,TextView txtBirthDay, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("User",Context.MODE_PRIVATE);
        txtFullName.setText(sharedPreferences.getString("name",""));
        txtGendar.setText(sharedPreferences.getString("gender",""));
        txtEmail.setText(sharedPreferences.getString("mail",""));
        txtPhone.setText(sharedPreferences.getString("phone",""));
        String birthDayTimestamp=sharedPreferences.getString("birthDay","");
        String birthDay="";
        if (!birthDayTimestamp.isEmpty()){
            birthDay=GlobalValue.getDate(Long.parseLong(birthDayTimestamp));
        }
        txtBirthDay.setText(birthDay);
        Glide.with(context)
                .asBitmap()
                .load(sharedPreferences.getString("photoURL",""))
                .into(imgAvatar);


    }
}
