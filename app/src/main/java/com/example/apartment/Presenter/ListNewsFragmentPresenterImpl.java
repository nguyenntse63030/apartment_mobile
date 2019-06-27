package com.example.apartment.Presenter;


import com.example.apartment.Api.NewsApi;
import com.example.apartment.Contract.ListNewsFragmentContract;
import com.example.apartment.Global.GlobalValue;
import com.example.apartment.Listener.List_News_Listener;
import com.example.apartment.Model.News;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListNewsFragmentPresenterImpl implements ListNewsFragmentContract.listNewsFragmentPresenter {
    private List<News> listNews = new ArrayList<>();
    private ListNewsFragmentContract.listNewsFragmentView view;
    private ListNewsFragmentAdapterPresenterImpl listNewsFragmentAdapterPresenter;
    private NewsApi newsApi;

    public ListNewsFragmentPresenterImpl(ListNewsFragmentContract.listNewsFragmentView view) {
        this.view = view;
    }

    @Override
    public void loadListNewsData() {
        newsApi = GlobalValue.retrofit.create(NewsApi.class);
        try {
            Call<JsonElement> call = newsApi.getNews();
            call.enqueue(new Callback<JsonElement>() {
                @Override
                public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {

                    JsonElement responseData = response.body();
                    JsonParser parser = new JsonParser();

                    JsonObject responseObj = parser.parse(responseData.toString()).getAsJsonObject();
                    JsonArray news = responseObj.get("listNews").getAsJsonArray();

                    for (int i = 0;i < news.size();i++){
                        JsonObject newsObj = news.get(i).getAsJsonObject();
                        Gson gsonSP = new Gson();

                        News newsItem = gsonSP.fromJson(newsObj.toString(),News.class);
                        listNews.add(newsItem);
                    }

                    listNewsFragmentAdapterPresenter = new ListNewsFragmentAdapterPresenterImpl(listNews, (List_News_Listener) view);
                    view.setAdapter(listNewsFragmentAdapterPresenter);
                }
                @Override
                public void onFailure(Call<JsonElement> call, Throwable t) {
                    System.out.println(t.getMessage());
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
