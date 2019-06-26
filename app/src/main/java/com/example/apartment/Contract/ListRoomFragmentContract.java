package com.example.apartment.Contract;


public class ListRoomFragmentContract {
    public interface listRoomFragmentPresenter{
//        void createAdapter();
        void loadListRoomData();
    }

    public interface listRoomFragmentView{
        void setAdapter(ListRoomFragmentAdapterContract.listRoomFragmentAdapterPresenter listNewsFragmentAdapterPresenter);

    }

}
