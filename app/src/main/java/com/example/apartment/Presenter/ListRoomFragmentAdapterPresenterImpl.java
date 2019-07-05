package com.example.apartment.Presenter;


import android.content.Context;
import android.widget.Filter;

import com.example.apartment.Adapter.ListRoomFragmentAdapter;
import com.example.apartment.Contract.ListRoomFragmentAdapterContract;
import com.example.apartment.Listener.Room_Listener;
import com.example.apartment.Model.Room;

import java.util.ArrayList;
import java.util.List;

public class ListRoomFragmentAdapterPresenterImpl implements ListRoomFragmentAdapterContract.listRoomFragmentAdapterPresenter {
    private List<Room> roomList;
    private Room_Listener listener;
    private ListRoomFragmentAdapter adapter;

    public ListRoomFragmentAdapterPresenterImpl(List<Room> roomList, Room_Listener listener,ListRoomFragmentAdapter adapter) {
        this.roomList = roomList;
        this.adapter=adapter;
        this.listener = listener;
    }

    @Override
    public int returnListRoomSize() {
        return roomList.size();
    }

    @Override
    public void setAdapter(ListRoomFragmentAdapter adapter) {
        this.adapter=adapter;
    }

    @Override
    public void onClickItemRoom(int position) {

//        String roomNumber = roomList.get(position).getRoomNumber();
//        String address = roomList.get(position).getApartment().getName();
//        String apartment = roomList.get(position).getApartment().getName();
//        String signDate = roomList.get(position).getSignDate();
//        String expiredDate = roomList.get(position).getExpiredDate();
//        String district = roomList.get(position).getApartment().getAddress();
//        String id = roomList.get(position).getCode();
//        int unpayBill = roomList.get(position).getNumberUnpayBill();
//        int totalBill = roomList.get(position).getTotalBill();
//        String owner = roomList.get(position).getUser().getName();

        Room room = roomList.get(position);
        listener.onClickRoomItem(room);
    }

    @Override
    public void onBindViewHolder(ListRoomFragmentAdapter.MyViewHolder holder, int position) {
        holder.getLbRoomNumber().setText(""+roomList.get(position).getRoomNumber());
        holder.getTxtRoomNumber().setText("Room number: "+roomList.get(position).getRoomNumber());
        holder.getTxtAddress().setText("Address: "+roomList.get(position).getUser().getAddress());
        holder.getTxtApartment().setText(roomList.get(position).getApartment().getName());
        holder.getTxtDistrict().setText("District: "+roomList.get(position).getApartment().getAddress());
        holder.getTxtRoomID().setText("Room ID: "+roomList.get(position).getCode());
        holder.getTxtSignDate().setText("Sign date: "+roomList.get(position).getSignDate());
        holder.getTxtUnpayBillNumber().setText("Unpay bill : "+roomList.get(position).getNumberUnpayBill());
    }

    @Override
    public void filterList(List<Room> filteredList) {
        roomList = filteredList;
        adapter.notifyDataSetChanged();
    }


}
