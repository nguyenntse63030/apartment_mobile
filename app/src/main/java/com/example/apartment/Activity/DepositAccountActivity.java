package com.example.apartment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.apartment.Contract.DepositAccountActivityContract;
import com.example.apartment.Presenter.DepositAccountActivityPresenterImpl;
import com.example.apartment.R;
import com.google.android.material.textfield.TextInputEditText;
import com.makeramen.roundedimageview.RoundedImageView;

public class DepositAccountActivity extends AppCompatActivity {
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
}
