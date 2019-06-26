package com.example.apartment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.example.apartment.R;

public class LoginActivity extends AppCompatActivity {

    private ScrollView scrollViewLogin;

    private Button btnSignIn, btnSignInGoogle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignInGoogle = findViewById(R.id.btnSignInGoogle);
        scrollViewLogin = findViewById(R.id.scrollViewLogin);

    }

    @Override
    protected void onStart() {
        super.onStart();
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        scrollViewLogin.setOverScrollMode(View.OVER_SCROLL_NEVER);
    }
}
