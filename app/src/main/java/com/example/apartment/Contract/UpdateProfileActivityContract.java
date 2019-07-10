package com.example.apartment.Contract;

import android.content.Context;

import com.google.android.material.textfield.TextInputEditText;
import com.makeramen.roundedimageview.RoundedImageView;

public class UpdateProfileActivityContract {
    public interface UpdateProfileActivityPresenter{
        void fillData(Context context, RoundedImageView imgAvatar, TextInputEditText editName,TextInputEditText editGender,TextInputEditText editBirthDay);
        void updateUser(Context context, RoundedImageView imgAvatar, TextInputEditText editName,TextInputEditText editGender,TextInputEditText editBirthDay);
    }
    public interface UpdateProfileActivityView{
        void changePage();
    }
}
