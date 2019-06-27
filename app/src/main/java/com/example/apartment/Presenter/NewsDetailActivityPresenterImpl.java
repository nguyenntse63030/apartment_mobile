package com.example.apartment.Presenter;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.apartment.Contract.NewsDetailActivityContract;
import com.example.apartment.Model.News;

public class NewsDetailActivityPresenterImpl implements NewsDetailActivityContract.newsDetailActivityPresenter {
    @Override
    public void fillData(Intent intent, TextView txtDateOfNews,
                         TextView txtNewsTitle, TextView txtNewsContentDetail,
                         ImageView newsDetailImage, Context context) {

        News news = (News) intent.getSerializableExtra("news");
        txtDateOfNews.setText(news.getDateOfNews());
        txtNewsTitle.setText(news.getNewsTitle());
        txtNewsContentDetail.setText(news.getNewsContentDetail());
//        newsDetailImage.setImageResource(news.getNewsImage());
//        Glide.with(context)
//                .asBitmap()
//                .load(news.getNewsImage())
//                .into(newsDetailImage);
    }
}
