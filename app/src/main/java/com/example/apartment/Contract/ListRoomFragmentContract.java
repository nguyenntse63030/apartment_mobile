package com.example.apartment.Contract;


import android.content.Context;

import com.example.apartment.Adapter.ListRoomFragmentAdapter;
import com.google.android.material.textfield.TextInputEditText;

public class ListRoomFragmentContract {
    public interface listRoomFragmentPresenter{
//        void createAdapter();
        void setAdapter(ListRoomFragmentAdapter adapter);
        void addActionSearch(TextInputEditText editSearch);
        void loadListRoomData(Context context);
    }

    public interface listRoomFragmentView{
        void setAdapter(ListRoomFragmentAdapterContract.listRoomFragmentAdapterPresenter listNewsFragmentAdapterPresenter);

    }

}
