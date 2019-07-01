package com.example.apartment.Contract;

import android.content.Context;
import android.content.Intent;

import com.google.android.material.textfield.TextInputEditText;


public class LoginActivityContract {
    public interface LoginActivityPresenter{
        public void login(TextInputEditText phone, TextInputEditText password, Context context);
    }
    public interface  LoginActivityView{
        public void changePage();
    }
}
