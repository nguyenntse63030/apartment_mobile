package com.example.apartment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.apartment.Global.GlobalValue;
import com.example.apartment.R;

import java.util.Timer;
import java.util.TimerTask;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        //Set ProgressBar color
        ProgressBar spinner = findViewById(R.id.pbSpinner);
        spinner.getIndeterminateDrawable()
                .setColorFilter(Color.parseColor("#FFFFFF"),android.graphics.PorterDuff.Mode.MULTIPLY);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(LauncherActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(timerTask, GlobalValue.SPINER_LOADING_TIME_OUT);
    }
}
