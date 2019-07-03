package com.example.apartment.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.apartment.Contract.RoomDetailActivityContract;
import com.example.apartment.Fragment.ListBillOfRoomFragment;
import com.example.apartment.Presenter.RoomDetailActivityPresenterImpl;
import com.example.apartment.R;

public class RoomDetailActivity extends AppCompatActivity {

    TextView lbRoomNumber,txtRoomID,  txtRoomNumber,  txtDistrict,  txtUnpayBillNumber
                ,  txtTotalBillNumber,  txtSignDate,  txtExpireDate, txtOwnerName, txtApartment;
    RoomDetailActivityContract.RoomDetailActivityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);
        //Ánh xạ
        lbRoomNumber = findViewById(R.id.lbRoomNumber);
        txtRoomID = findViewById(R.id.txtRoomID);
        txtRoomNumber = findViewById(R.id.txtRoomNumber);
        txtDistrict = findViewById(R.id.txtDistrict);
        txtUnpayBillNumber = findViewById(R.id.txtUnpayBillNumber);
        txtTotalBillNumber = findViewById(R.id.txtTotalBillNumber);
        txtSignDate = findViewById(R.id.txtSignDate);
        txtExpireDate = findViewById(R.id.txtExpireDate);
        txtOwnerName = findViewById(R.id.txtOwnerName);
        txtApartment = findViewById(R.id.txtApartment);

        presenter = new RoomDetailActivityPresenterImpl();
        Intent intent = RoomDetailActivity.this.getIntent();
        presenter.fillData(intent,lbRoomNumber,txtRoomID,  txtRoomNumber,  txtDistrict,  txtUnpayBillNumber
                ,  txtTotalBillNumber,  txtSignDate,  txtExpireDate, txtOwnerName, txtApartment);

        ListBillOfRoomFragment listBillOfRoomFragment = new ListBillOfRoomFragment();
        loadFragment(listBillOfRoomFragment);


    }



    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void clickToBack(View view) {
        finish();
    }

    private void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout, fragment);
        fragmentTransaction.commit();
    }
}
