package com.example.apartment.Presenter;

import android.content.Intent;
import android.widget.TextView;

import com.example.apartment.Contract.RoomDetailActivityContract;
import com.example.apartment.Model.Room;

public class RoomDetailActivityPresenterImpl implements RoomDetailActivityContract.RoomDetailActivityPresenter {
    @Override
    public void fillData(Intent intent, TextView lbRoomNumber, TextView txtRoomID, TextView txtRoomNumber
            , TextView txtDistrict, TextView txtUnpayBillNumber, TextView txtTotalBillNumber
            , TextView txtSignDate, TextView txtExpireDate, TextView txtOwnerName, TextView txtApartment) {
        //load data from intent
        Room room = (Room) intent.getSerializableExtra("room");
        //input data
        lbRoomNumber.setText("Room "+room.getNumber());
        txtRoomID.setText("Code: "+room.getID());
        txtRoomNumber.setText("Number: "+room.getNumber());
        txtDistrict.setText("District: "+room.getDistrict());
        txtUnpayBillNumber.setText("Unpay bill: "+room.getNumberUnpayBill());
        txtTotalBillNumber.setText("Total bill: "+room.getTotalBill());
        txtSignDate.setText("Sign Date: "+room.getSignDate());
        txtExpireDate.setText("Expired Date: "+room.getExpiredDate());
        txtOwnerName.setText("Owner: "+room.getOwnerName());
        txtApartment.setText("Apartment: "+room.getApartmentName());
    }
}
