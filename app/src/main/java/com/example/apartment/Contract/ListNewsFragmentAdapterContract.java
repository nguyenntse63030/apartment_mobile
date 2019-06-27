package com.example.apartment.Contract;

import android.content.Context;

import com.example.apartment.Adapter.ListNewsFragmentAdapter;

public class ListNewsFragmentAdapterContract {
    public interface listNewsFragmentAdapterPresenter {
        int returnListNewsSize();
        void onClickItemNews(int position);
        void onBindViewHolder(ListNewsFragmentAdapter.MyViewHolder holder, int position, Context context);
    }
}
