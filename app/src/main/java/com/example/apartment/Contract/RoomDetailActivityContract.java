package com.example.apartment.Contract;

import android.content.Intent;
import android.widget.TextView;

public class RoomDetailActivityContract {
    public interface RoomDetailActivityPresenter{
        public void fillData(Intent intent, TextView lbRoomNumber,
                             TextView txtRoomID, TextView txtRoomNumber, TextView txtDistrict, TextView txtUnpayBillNumber
                , TextView txtTotalBillNumber, TextView txtSignDate, TextView txtExpireDate,TextView txtOwnerName,TextView txtApartment);
    }
}
