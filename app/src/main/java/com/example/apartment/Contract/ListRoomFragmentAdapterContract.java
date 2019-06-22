package com.example.apartment.Contract;

import com.example.apartment.Adapter.ListRoomFragmentAdapter;

public class ListRoomFragmentAdapterContract {
    public interface listRoomFragmentAdapterPresenter {
        int returnListRoomSize();
        void onClickItemRoom(int position);
        void onBindViewHolder(ListRoomFragmentAdapter.MyViewHolder holder, int position);
    }
}
