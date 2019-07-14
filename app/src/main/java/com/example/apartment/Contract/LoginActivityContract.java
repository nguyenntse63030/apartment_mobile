package com.example.apartment.Contract;

import android.content.Context;
import android.content.Intent;

import com.google.android.material.textfield.TextInputEditText;


public class LoginActivityContract {
    public interface LoginActivityPresenter{
        void login(TextInputEditText phone, TextInputEditText password, Context context);
        void onActivityResult(int requestCode, int resultCode, Intent data);
    }
    public interface  LoginActivityView{
        void changePage();
        void loginFailed();
        void closeDialog();
        void showDialog();
        void showMessErr(String errorMess);
    }
}
