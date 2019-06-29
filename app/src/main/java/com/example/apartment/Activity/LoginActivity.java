package com.example.apartment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import com.example.apartment.Contract.LoginActivityContract;
import com.example.apartment.Presenter.LoginActivityPresenterImpl;
import com.example.apartment.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText editPhone,editPassword;
    private ScrollView scrollViewLogin;
    private  LoginActivityContract.LoginActivityPresenter presenter;

    private Button btnSignIn, btnSignInGoogle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignInGoogle = findViewById(R.id.btnSignInGoogle);
        scrollViewLogin = findViewById(R.id.scrollViewLogin);
        editPhone = findViewById(R.id.editPhone);
        editPassword = findViewById(R.id.editPassword);
        presenter = new LoginActivityPresenterImpl();

    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent= new Intent(LoginActivity.this, HomeActivity.class);
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
            String token = sharedPreferences.getString("token","");
            if(!token.isEmpty()){
                startActivity(intent);
                finish();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        SharedPreferences.Editor editor = getSharedPreferences("User", MODE_PRIVATE).edit();
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String phone = editPhone.getText().toString();
                    String password = editPassword.getText().toString();
                    Intent intentOnclick= new Intent(LoginActivity.this, HomeActivity.class);
                    presenter.login(intentOnclick,phone,password,getApplicationContext());
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        scrollViewLogin.setOverScrollMode(View.OVER_SCROLL_NEVER);
    }


}

