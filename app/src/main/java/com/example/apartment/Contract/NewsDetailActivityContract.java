package com.example.apartment.Contract;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsDetailActivityContract {
    public interface newsDetailActivityPresenter{
        public void fillData(Intent intent, TextView txtDateOfNews,
                             TextView txtNewsTitle, TextView txtNewsContentDetail,
                             ImageView newsDetailImage);
    }
}
