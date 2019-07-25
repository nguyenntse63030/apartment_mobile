package com.example.apartment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.apartment.R;
import com.google.android.material.textfield.TextInputEditText;
import com.makeramen.roundedimageview.RoundedImageView;

public class DepositAccountViewMoneyActivity extends AppCompatActivity {
    private TextInputEditText editAccountView;
    private RoundedImageView imgAvatarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit_account_view_money);
        editAccountView = findViewById(R.id.editAccountView);
        imgAvatarView = findViewById(R.id.imgAvatarView);

    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
        String urlPhoto = sharedPreferences.getString("photoURL", "");
        int account = sharedPreferences.getInt("account", 0);

        Glide.with(this).asBitmap().load(urlPhoto).into(imgAvatarView);
        editAccountView.setText(String.format("%,d",account)+" đ");
    }

    public void clickToBack(View view) {
        finish();
    }

    public void clickToPayment(View view) {
        Intent intent = new Intent(getApplicationContext(),DepositAccountChooseTypeActivity.class);
        startActivity(intent);
    }
}
