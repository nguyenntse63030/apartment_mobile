package com.example.apartment.Contract;

import com.example.apartment.Presenter.ListRoomFragmentAdapterPresenterImpl;

public class ListRoomFragmentContract {
    public interface listRoomFragmentPresenter{
//        void createAdapter();
        void inputListRoomData();
    }

    public interface listRoomFragmentView{
        void setAdapter(ListRoomFragmentAdapterContract.listRoomFragmentAdapterPresenter listNewsFragmentAdapterPresenter);

    }

}
