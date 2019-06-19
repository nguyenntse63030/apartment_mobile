package com.example.apartment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apartment.Presenter.NewsDetailActivityPresenterImpl;
import com.example.apartment.R;

public class NewsDetailActivity extends AppCompatActivity {

    private TextView txtDateOfNews, txtNewsTitle, txtNewsContentDetail;
    private ImageView newsDetailImage;
    private NewsDetailActivityPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        txtDateOfNews = findViewById(R.id.txtDateOfNews);
        txtNewsContentDetail = findViewById(R.id.txtNewsContentDetail);
        txtNewsTitle = findViewById(R.id.txtNewsTitle);
        newsDetailImage = findViewById(R.id.newsDetailImage);

        presenter = new NewsDetailActivityPresenterImpl();

        Intent intent = NewsDetailActivity.this.getIntent();
        presenter.fillData(intent, txtDateOfNews, txtNewsTitle, txtNewsContentDetail, newsDetailImage);

    }

    public void clickToBack(View view) {
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
