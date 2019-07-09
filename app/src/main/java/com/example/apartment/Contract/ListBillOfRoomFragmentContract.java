package com.example.apartment.Contract;

import android.content.Context;

import com.example.apartment.Adapter.ListBillOfRoomFragmentAdapter;
import com.example.apartment.Presenter.ListRoomFragmentAdapterPresenterImpl;
import com.google.android.material.textfield.TextInputEditText;

public class ListBillOfRoomFragmentContract {
    public interface listBillFragmentPresenter{
        void setAdapter(ListBillOfRoomFragmentAdapter adapter);
        void addActionSearch(TextInputEditText editSearch);
        void loadListBillData(String roomId,Context context);
    }

    public interface listBillFragmentView{
        void setAdapter(ListBillOfRoomFragmentAdapterContract.ListBillOfRoomFragmentAdapterPresenter listBillOfRoomFragmentAdapterPresenter);
    }
}
