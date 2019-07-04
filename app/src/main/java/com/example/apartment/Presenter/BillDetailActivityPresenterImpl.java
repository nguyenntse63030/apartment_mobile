package com.example.apartment.Presenter;

import android.content.Intent;
import android.widget.TextView;

import com.example.apartment.Contract.BillDetailActivityContract;
import com.example.apartment.Model.Bills;

public class BillDetailActivityPresenterImpl implements BillDetailActivityContract.BillDetailActivityPresenter {
    @Override
    public void fillData(Intent intent, TextView txtBillCode, TextView txtType, TextView txtRoomCode,
                         TextView txtRoomNumber, TextView txtApartment, TextView txtCreateDate,
                         TextView txtExpireDate, TextView txtOldNumber, TextView txtNewNumber,
                         TextView txtUsedNumber, TextView txtTotal, TextView txtStatus) {
        Bills bill = (Bills) intent.getSerializableExtra("bill");
        txtBillCode.setText(bill.getCode());
        txtType.setText(bill.getType());
        txtRoomCode.setText(bill.getRoom().getCode());
        txtRoomNumber.setText(bill.getRoom().getRoomNumber());
        txtApartment.setText(bill.getApartment().getName());
        txtCreateDate.setText(bill.getCreatedTime());
        txtExpireDate.setText(bill.getExpiredTime());
        txtOldNumber.setText(String.valueOf(bill.getOldNumber()));
        txtNewNumber.setText(String.valueOf(bill.getNewNumber()));
        txtUsedNumber.setText(String.valueOf(bill.getUsedNumber()));
        txtTotal.setText(String.valueOf(bill.getTotal()));
        txtStatus.setText(bill.getStatus());

    }
}
