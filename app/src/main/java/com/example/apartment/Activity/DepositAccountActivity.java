package com.example.apartment.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.apartment.Contract.DepositAccountActivityContract;
import com.example.apartment.Presenter.DepositAccountActivityPresenterImpl;
import com.example.apartment.R;
import com.google.android.material.textfield.TextInputEditText;
import com.makeramen.roundedimageview.RoundedImageView;

public class DepositAccountActivity extends AppCompatActivity implements DepositAccountActivityContract.DepositAccountActivityView {
    private TextInputEditText editAccount,editCash;
    private RoundedImageView imgAvatar;
    private DepositAccountActivityContract.DepositAccountActivityPresenter presenter;
    private Button btnDeposit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit_account);
        editAccount = findViewById(R.id.editAccount);
        editCash = findViewById(R.id.editCash);
        imgAvatar = findViewById(R.id.imgAvatar);

        btnDeposit = findViewById(R.id.btnDeposit);
        presenter = new DepositAccountActivityPresenterImpl(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        editAccount.setEnabled(false);
        presenter.fillData(getApplicationContext(),imgAvatar,editAccount,editCash);
        btnDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.depositAccount(getApplicationContext(),imgAvatar,editAccount,editCash);
            }
        });
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
}
