package com.example.apartment.Fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.apartment.R;


public class ListBillFragment extends Fragment {
    private TextView txtUnpayBill, txtPaidBill;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_bill_fragment, container, false);
        txtUnpayBill = view.findViewById(R.id.txtUnpayBill);
        txtPaidBill = view.findViewById(R.id.txtPaidBill);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        UnpayBillFragment unpayBillFragment = new UnpayBillFragment();
        loadFragment(unpayBillFragment);

        txtPaidBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtPaidBill.setBackgroundResource(R.drawable.back_ground_bill_on_select);
                txtPaidBill.setElevation(5);
                txtPaidBill.setTextColor(Color.parseColor("#FFFFFF"));

                txtUnpayBill.setBackgroundResource(R.drawable.back_ground_bill_not_select);
                txtUnpayBill.setElevation(0);
                txtUnpayBill.setTextColor(Color.parseColor("#000000"));


                PaidBillFragment paidBillFragment = new PaidBillFragment();
                loadFragment(paidBillFragment);
            }
        });

        txtUnpayBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtUnpayBill.setBackgroundResource(R.drawable.back_ground_bill_on_select);
                txtUnpayBill.setElevation(5);
                txtUnpayBill.setTextColor(Color.parseColor("#FFFFFF"));

                txtPaidBill.setBackgroundResource(R.drawable.back_ground_bill_not_select);
                txtPaidBill.setElevation(0);
                txtPaidBill.setTextColor(Color.parseColor("#000000"));

                UnpayBillFragment unpayBillFragment = new UnpayBillFragment();
                loadFragment(unpayBillFragment);

            }
        });
    }

    private void loadFragment(Fragment fragment){
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.unpay_paid_bill_layout, fragment)
                .commit();
    }
}
