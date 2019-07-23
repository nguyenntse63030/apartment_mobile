package com.example.apartment.Contract;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

public class BillDetailActivityContract {
    public interface BillDetailActivityPresenter{
        void fillData(Intent intent, TextView txtBillCode, TextView txtType,
                      TextView txtRoomCode, TextView txtRoomNumber, TextView txtApartment,
                      TextView txtCreateDate, TextView txtExpireDate, TextView txtOldNumber, TextView txtNewNumber
                , TextView txtUsedNumber, TextView txtTotal, TextView txtStatus, Button btnPay,Context context,TextView lbOldNumber,TextView lbNewNumber,TextView lbUsedNumber);
        void payBill(Intent intent,Button btnPay,Context context, TextView txtStatus);
    }
    public interface  BillDetailActivityView{
        void showDialog(String message);
        void showDialogConfirm();
    }
}
