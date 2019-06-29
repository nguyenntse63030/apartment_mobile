package com.example.apartment.Contract;

import android.content.Context;
import android.content.Intent;


public class LoginActivityContract {
    public interface LoginActivityPresenter{
        public void login(Intent intent, String phone, String password, Context context);
    }
}
