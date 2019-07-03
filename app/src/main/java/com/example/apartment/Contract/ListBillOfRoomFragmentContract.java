package com.example.apartment.Contract;

import android.content.Context;

import com.example.apartment.Presenter.ListRoomFragmentAdapterPresenterImpl;

public class ListBillOfRoomFragmentContract {
    public interface listBillFragmentPresenter{
        void loadListBillData(String roomId);
    }

    public interface listBillFragmentView{
        void setAdapter(ListBillOfRoomFragmentAdapterContract.ListBillOfRoomFragmentAdapterPresenter listBillOfRoomFragmentAdapterPresenter);
    }
}
