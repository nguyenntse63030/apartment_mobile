package com.example.apartment.Contract;

import com.example.apartment.Adapter.ListNewsFragmentAdapter;

public class ListNewsFragmentAdapterContract {
    public interface listNewsFragmentAdapterPresenter {
        int returnListNewsSize();
        void onClickItemNews(int position);
        void onBindViewHolder(ListNewsFragmentAdapter.MyViewHolder holder, int position);
    }
}
