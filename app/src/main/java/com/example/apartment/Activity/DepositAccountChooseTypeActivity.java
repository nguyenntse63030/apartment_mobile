package com.example.apartment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.apartment.R;

public class DepositAccountChooseTypeActivity extends AppCompatActivity {
    private Button btnChoose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit_account_choose_type);
        btnChoose = findViewById(R.id.btnChoose);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DepositAccountActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void clickToBack(View view) {
        finish();
    }
}
