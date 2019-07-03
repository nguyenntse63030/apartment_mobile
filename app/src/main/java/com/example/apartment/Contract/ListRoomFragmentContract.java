package com.example.apartment.Contract;


import android.content.Context;

public class ListRoomFragmentContract {
    public interface listRoomFragmentPresenter{
//        void createAdapter();
        void loadListRoomData(Context context);
    }

    public interface listRoomFragmentView{
        void setAdapter(ListRoomFragmentAdapterContract.listRoomFragmentAdapterPresenter listNewsFragmentAdapterPresenter);

    }

}
