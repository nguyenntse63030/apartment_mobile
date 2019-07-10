package com.example.apartment.Contract;

import android.content.Context;

import com.google.android.material.textfield.TextInputEditText;
import com.makeramen.roundedimageview.RoundedImageView;

public class DepositAccountActivityContract {
    public interface DepositAccountActivityPresenter{
        void fillData(Context context, RoundedImageView imgAvatar, TextInputEditText editAccount,TextInputEditText editCash);
        void depositAccount(Context context, RoundedImageView imgAvatar, TextInputEditText editAccount,TextInputEditText editCash);
    }
}
