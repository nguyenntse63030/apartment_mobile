package com.example.apartment.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apartment.Contract.BillDetailActivityContract;
import com.example.apartment.Model.Bills;
import com.example.apartment.Presenter.BillDetailActivityPresenterImpl;
import com.example.apartment.R;

public class BillDetailActivity extends AppCompatActivity implements BillDetailActivityContract.BillDetailActivityView {
    private TextView txtBillCode,txtType,txtRoomCode,txtRoomNumber,txtApartment,
            txtCreateDate,txtExpireDate,txtOldNumber,txtNewNumber,txtUsedNumber,txtTotal,txtStatus;
    private Button btnPay;
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
        btnPay = findViewById(R.id.btnPay);
        Intent intent = getIntent();
        presenter = new BillDetailActivityPresenterImpl(this);
        presenter.fillData(intent,txtBillCode,txtType,txtRoomCode,txtRoomNumber,txtApartment,
                txtCreateDate,txtExpireDate,txtOldNumber,txtNewNumber,txtUsedNumber,txtTotal,txtStatus,btnPay,getApplicationContext());

    }

    public void clickToBack(View view) {
        finish();
    }

    @Override
    public void showDialog(String message) {
        AlertDialog.Builder mess = new AlertDialog.Builder(this);
        mess.setTitle("Notification");

        mess.setMessage(message)
                .setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog showMess = mess.create();
        showMess.show();
    }

    @Override
    public void showDialogConfirm() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        Intent intent = getIntent();
                        presenter.payBill(intent,btnPay,getApplicationContext(),txtStatus);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked

                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }
}
