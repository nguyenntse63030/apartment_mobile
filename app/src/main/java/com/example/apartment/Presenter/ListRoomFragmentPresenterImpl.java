package com.example.apartment.Presenter;

import com.example.apartment.Contract.ListRoomFragmentAdapterContract;
import com.example.apartment.Contract.ListRoomFragmentContract;
import com.example.apartment.Listener.Room_Listener;
import com.example.apartment.Model.Room;

import java.util.ArrayList;
import java.util.List;

public class ListRoomFragmentPresenterImpl implements ListRoomFragmentContract.listRoomFragmentPresenter {
    private List<Room> listRoom = new ArrayList<>();
    private ListRoomFragmentContract.listRoomFragmentView view;
    private ListRoomFragmentAdapterContract.listRoomFragmentAdapterPresenter adapterPresenter;

    public ListRoomFragmentPresenterImpl(ListRoomFragmentContract.listRoomFragmentView view) {
        this.view = view;
    }

    @Override
    public void createAdapter() {
        adapterPresenter = new ListRoomFragmentAdapterPresenterImpl(listRoom, (Room_Listener) view);
        view.setAdapter(adapterPresenter);
    }

    @Override
    public void inputListRoomData() {
        listRoom.add(new Room("ABC_123","103","123/456 khu pho 1 phuong ABC TP.XYZ Tinh ASD"
                ,"Quan 12","12/4/2000","2","Chung cu The perk"));
        listRoom.add(new Room("ABC_123","103","123/456 khu pho 1 phuong ABC TP.XYZ Tinh ASD"
                ,"Quan 12","12/4/2000","2","Chung cu The perk"));
        listRoom.add(new Room("ABC_123","103","123/456 khu pho 1 phuong ABC TP.XYZ Tinh ASD"
                ,"Quan 12","12/4/2000","2","Chung cu The perk"));
        listRoom.add(new Room("ABC_123","103","123/456 khu pho 1 phuong ABC TP.XYZ Tinh ASD"
                ,"Quan 12","12/4/2000","2","Chung cu The perk"));
        listRoom.add(new Room("ABC_123","103","123/456 khu pho 1 phuong ABC TP.XYZ Tinh ASD"
                ,"Quan 12","12/4/2000","2","Chung cu The perk"));
        listRoom.add(new Room("ABC_123","103","123/456 khu pho 1 phuong ABC TP.XYZ Tinh ASD"
                ,"Quan 12","12/4/2000","2","Chung cu The perk"));
        listRoom.add(new Room("ABC_123","103","123/456 khu pho 1 phuong ABC TP.XYZ Tinh ASD"
                ,"Quan 12","12/4/2000","2","Chung cu The perk"));

    }
}
