package com.example.apartment.Contract;

import android.content.Context;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

public class ProfileActivityContract {
    public interface ProfileActivityPresenter{
        void fillData(RoundedImageView imgAvatar,
                TextView txtFullName, TextView txtGendar, TextView txtPhone,
                      TextView txtEmail, TextView txtBirthDay, Context context);
    }
}
