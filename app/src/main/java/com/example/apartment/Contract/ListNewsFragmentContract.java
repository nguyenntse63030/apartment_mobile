package com.example.apartment.Contract;


import android.content.Context;

import com.example.apartment.Presenter.ListNewsFragmentAdapterPresenterImpl;


public class ListNewsFragmentContract {
    public interface listNewsFragmentPresenter{
        void loadListNewsData(Context context);
    }

    public interface listNewsFragmentView{
        void setAdapter(ListNewsFragmentAdapterPresenterImpl listNewsFragmentAdapterPresenter);
    }
}
