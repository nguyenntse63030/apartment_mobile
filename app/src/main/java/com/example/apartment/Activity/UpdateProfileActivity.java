package com.example.apartment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.apartment.Contract.UpdateProfileActivityContract;
import com.example.apartment.Presenter.UpdateProfileActivityPresenterImpl;
import com.example.apartment.R;
import com.google.android.material.textfield.TextInputEditText;
import com.makeramen.roundedimageview.RoundedImageView;

public class UpdateProfileActivity extends AppCompatActivity implements UpdateProfileActivityContract.UpdateProfileActivityView {
    private TextInputEditText editName,editGender,editBirthDay;
    private RoundedImageView imgAvatar;
    private UpdateProfileActivityContract.UpdateProfileActivityPresenter presenter;
    private Button btnUpdateProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        editName = findViewById(R.id.editName);
        editGender = findViewById(R.id.editGender);
        editBirthDay = findViewById(R.id.editBirthDay);
        imgAvatar = findViewById(R.id.imgAvatarUpdate);

        btnUpdateProfile = findViewById(R.id.btnUpdate);
        presenter = new UpdateProfileActivityPresenterImpl(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.fillData(getApplicationContext(),imgAvatar,editName,editGender,editBirthDay);
        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateUser(getApplicationContext(),imgAvatar,editName,editGender,editBirthDay);
            }
        });
    }

    public void clickToBack(View view) {
        finish();
    }

    @Override
    public void changePage() {
        Intent intentOnclick= new Intent(UpdateProfileActivity.this, ProfileActivity.class);
        intentOnclick.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intentOnclick);
        finish();
    }
}
