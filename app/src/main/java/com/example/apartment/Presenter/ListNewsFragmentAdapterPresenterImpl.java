package com.example.apartment.Presenter;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.example.apartment.Adapter.ListNewsFragmentAdapter;
import com.example.apartment.Contract.ListNewsFragmentAdapterContract;
import com.example.apartment.Listener.List_News_Listener;
import com.example.apartment.Model.News;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

import java.util.List;

public class ListNewsFragmentAdapterPresenterImpl implements ListNewsFragmentAdapterContract.listNewsFragmentAdapterPresenter {
    private List<News> listNews;
    private List_News_Listener mCallback;

    public ListNewsFragmentAdapterPresenterImpl(List<News> listNews, List_News_Listener mCallback) {
        this.listNews = listNews;
        this.mCallback = mCallback;
    }

    @Override
    public int returnListNewsSize() {
        return listNews.size();
    }

    @Override
    public void onClickItemNews(int position) {
        String newsTitle = listNews.get(position).getNewsTitle();
        String newsContentDetail = listNews.get(position).getNewsContentDetail();
        String dateOfNews = listNews.get(position).getDateOfNews();
        int newsImage = listNews.get(position).getNewsImage();

        News news = new News(newsTitle, newsContentDetail, dateOfNews, newsImage);
        mCallback.onClickNewsItem(news);
    }

    @Override
    public void onBindViewHolder(ListNewsFragmentAdapter.MyViewHolder holder, int position, Context context) {
//        holder.getNewsImage().setImageResource(listNews.get(position).getNewsImage());
        try{
            Glide.with(context)
                    .asBitmap()
                    .load("https://photo2.tinhte.vn/data/attachment-files/2015/07/3096360_underneath_the_tree-wallpaper-1920x1080.jpg")
                    .into(holder.getNewsImage());
            holder.getTxtNewsTitle().setText(listNews.get(position).getNewsTitle());
            holder.getTxtNewsDescription().setText(listNews.get(position).getNewsDescription());
            holder.getTxtDateOfNews().setText(listNews.get(position).getDateOfNews());
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}