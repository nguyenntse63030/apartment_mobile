package com.example.apartment.Model;

import java.io.Serializable;

public class News implements Serializable {
    String newsTitle;
    String newsDescription;
    String newsContentDetail;
    String dateOfNews;
    int newsImage;

    public News(String newsTitle, String newsDescription, int newsImage, String dateOfNews, String newsContentDetail) {
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.newsContentDetail = newsContentDetail;
        this.dateOfNews = dateOfNews;
        this.newsImage = newsImage;
    }

    public News(String newsTitle, String newsContentDetail, String dateOfNews, int newsImage) {
        this.newsTitle = newsTitle;
        this.newsContentDetail = newsContentDetail;
        this.dateOfNews = dateOfNews;
        this.newsImage = newsImage;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public String getNewsContentDetail() {
        return newsContentDetail;
    }

    public String getDateOfNews() {
        return dateOfNews;
    }

    public int getNewsImage() {
        return newsImage;
    }
}
