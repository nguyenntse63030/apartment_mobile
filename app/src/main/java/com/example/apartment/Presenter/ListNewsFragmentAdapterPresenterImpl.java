package com.example.apartment.Presenter;

import com.example.apartment.Adapter.ListNewsFragmentAdapter;
import com.example.apartment.Contract.ListNewsFragmentAdapterContract;
import com.example.apartment.Listener.List_News_Listener;
import com.example.apartment.Model.News;

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
    public void onBindViewHolder(ListNewsFragmentAdapter.MyViewHolder holder, int position) {
        holder.getNewsImage().setImageResource(listNews.get(position).getNewsImage());
        holder.getTxtNewsTitle().setText(listNews.get(position).getNewsTitle());
        holder.getTxtNewsDescription().setText(listNews.get(position).getNewsDescription());
        holder.getTxtDateOfNews().setText(listNews.get(position).getDateOfNews());
    }
}
