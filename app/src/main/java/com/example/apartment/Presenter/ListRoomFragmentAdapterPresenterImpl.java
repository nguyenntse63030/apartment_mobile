package com.example.apartment.Presenter;

import com.example.apartment.Adapter.ListRoomFragmentAdapter;
import com.example.apartment.Contract.ListRoomFragmentAdapterContract;
import com.example.apartment.Listener.Room_Listener;
import com.example.apartment.Model.Room;

import java.util.List;

public class ListRoomFragmentAdapterPresenterImpl implements ListRoomFragmentAdapterContract.listRoomFragmentAdapterPresenter {
    private List<Room> roomList;
    private Room_Listener listener;

    public ListRoomFragmentAdapterPresenterImpl(List<Room> roomList, Room_Listener listener) {
        this.roomList = roomList;
        this.listener = listener;
    }

    @Override
    public int returnListRoomSize() {
        return roomList.size();
    }

    @Override
    public void onClickItemRoom(int position) {

    }

    @Override
    public void onBindViewHolder(ListRoomFragmentAdapter.MyViewHolder holder, int position) {
        holder.getLbRoomNumber().setText(""+roomList.get(position).getNumber());
        holder.getTxtRoomNumber().setText("Room number: "+roomList.get(position).getNumber());
        holder.getTxtAddress().setText("Address: "+roomList.get(position).getAddress());
        holder.getTxtApartment().setText(roomList.get(position).getApartmentName());
        holder.getTxtDistrict().setText("District: "+roomList.get(position).getDistrict());
        holder.getTxtRoomID().setText("Room ID: "+roomList.get(position).getID());
        holder.getTxtSignDate().setText("Sign date: "+roomList.get(position).getDate());
        holder.getTxtUnpayBillNumber().setText("Unpay bill : "+roomList.get(position).getNumberUnpayBill());
    }
}
