package com.example.apartment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.apartment.Contract.BillDetailActivityContract;
import com.example.apartment.Model.Bills;
import com.example.apartment.Presenter.BillDetailActivityPresenterImpl;
import com.example.apartment.R;

public class BillDetailActivity extends AppCompatActivity {
    private TextView txtBillCode,txtType,txtRoomCode,txtRoomNumber,txtApartment,
            txtCreateDate,txtExpireDate,txtOldNumber,txtNewNumber,txtUsedNumber,txtTotal,txtStatus;
    private BillDetailActivityContract.BillDetailActivityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_detail);
        txtBillCode = findViewById(R.id.txtBillCode);
        txtType = findViewById(R.id.txtType);
        txtRoomCode = findViewById(R.id.txtRoomCode);
        txtRoomNumber = findViewById(R.id.txtRoomNumber);
        txtApartment = findViewById(R.id.txtApartment);
        txtCreateDate = findViewById(R.id.txtCreateDate);
        txtExpireDate = findViewById(R.id.txtExpireDate);
        txtOldNumber = findViewById(R.id.txtOldNumber);
        txtNewNumber = findViewById(R.id.txtNewNumber);
        txtUsedNumber = findViewById(R.id.txtUsedNumber);
        txtTotal = findViewById(R.id.txtTotal);
        txtStatus = findViewById(R.id.txtStatus);
        Intent intent = getIntent();
        presenter = new BillDetailActivityPresenterImpl();
        presenter.fillData(intent,txtBillCode,txtType,txtRoomCode,txtRoomNumber,txtApartment,
                txtCreateDate,txtExpireDate,txtOldNumber,txtNewNumber,txtUsedNumber,txtTotal,txtStatus);

    }

    public void clickToBack(View view) {
        finish();
    }
}
