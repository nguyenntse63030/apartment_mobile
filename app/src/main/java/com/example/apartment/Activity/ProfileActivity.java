package com.example.apartment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apartment.Contract.ProfileActivityContract;
import com.example.apartment.Presenter.ProfileActivityPresenterImpl;
import com.example.apartment.R;
import com.makeramen.roundedimageview.RoundedImageView;

public class ProfileActivity extends AppCompatActivity {
    private RoundedImageView imgAvatar;
    private TextView txtFullName,txtGendar,txtPhone,txtEmail,txtBirthDay;
    private Button btnUpdateProfile;
    private ProfileActivityContract.ProfileActivityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //ánh xạ
        imgAvatar = findViewById(R.id.imgAvatar);
        txtFullName = findViewById(R.id.txtFullName);
        txtGendar = findViewById(R.id.txtGendar);
        txtPhone = findViewById(R.id.txtPhone);
        txtEmail = findViewById(R.id.txtEmail);
        txtBirthDay = findViewById(R.id.txtBirthDay);
        btnUpdateProfile = findViewById(R.id.btnUpdateProfile);

        presenter = new ProfileActivityPresenterImpl();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //load dữ liệu khi start activity
        presenter.fillData(imgAvatar,txtFullName,txtGendar,txtPhone,txtEmail,txtBirthDay,getApplicationContext());
        //Thêm action khi click Update profile
        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,UpdateProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    public void clickToBack(View view) {
        finish();
    }
}
