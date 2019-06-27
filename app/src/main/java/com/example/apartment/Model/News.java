package com.example.apartment.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class News implements Serializable {
    @Expose
    @SerializedName("title")
    private String newsTitle;
    @SerializedName("description")
    private String newsDescription;
    @SerializedName("contentDetail")
    private String newsContentDetail;
    @SerializedName("createdTime")
    private String dateOfNews;
    @SerializedName("image")
    private String newsImage;

    public News(String newsTitle, String newsDescription, String newsImage, String dateOfNews, String newsContentDetail) {
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.newsContentDetail = newsContentDetail;
        this.dateOfNews = dateOfNews;
        this.newsImage = newsImage;
    }

    public News(String newsTitle, String newsContentDetail, String dateOfNews, String newsImage) {
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

    public String getNewsImage() {
        return newsImage;
    }
}
