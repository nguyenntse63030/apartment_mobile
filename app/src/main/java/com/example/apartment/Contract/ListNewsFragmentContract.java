package com.example.apartment.Contract;


import com.example.apartment.Presenter.ListNewsFragmentAdapterPresenterImpl;

public class ListNewsFragmentContract {
    public interface listNewsFragmentPresenter{
        void loadListNewsData();
    }

    public interface listNewsFragmentView{
        void setAdapter(ListNewsFragmentAdapterPresenterImpl listNewsFragmentAdapterPresenter);
    }
}
