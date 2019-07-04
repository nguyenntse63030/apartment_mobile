package com.example.apartment.Contract;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class BillDetailActivityContract {
    public interface BillDetailActivityPresenter{
        public void fillData(Intent intent,TextView txtBillCode,TextView txtType,
                             TextView txtRoomCode,TextView txtRoomNumber,TextView txtApartment,
                             TextView txtCreateDate,TextView txtExpireDate,TextView txtOldNumber,TextView txtNewNumber
                ,TextView txtUsedNumber,TextView txtTotal,TextView txtStatus);
    }
}
