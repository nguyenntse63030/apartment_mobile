package com.example.apartment.Contract;

import android.widget.Filter;

import com.example.apartment.Adapter.ListRoomFragmentAdapter;
import com.example.apartment.Model.Room;

import java.util.List;

public class ListRoomFragmentAdapterContract {
    public interface listRoomFragmentAdapterPresenter {
        int returnListRoomSize();
        void setAdapter(ListRoomFragmentAdapter adapter);
        void onClickItemRoom(int position);
        void onBindViewHolder(ListRoomFragmentAdapter.MyViewHolder holder, int position);
        void filterList(List<Room> roomList);
    }
}
