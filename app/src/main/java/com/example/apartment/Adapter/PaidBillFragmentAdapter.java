package com.example.apartment.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apartment.Presenter.PaidBillFragmentAdapterPresenterImpl;
import com.example.apartment.R;

public class PaidBillFragmentAdapter extends RecyclerView.Adapter<PaidBillFragmentAdapter.MyViewHolder>{
    private PaidBillFragmentAdapterPresenterImpl presenter;

    public PaidBillFragmentAdapter(PaidBillFragmentAdapterPresenterImpl presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bill, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        presenter.onBindViewHolder(holder, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickPaidBillItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return presenter.returnListPaidBillSize();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView txtRoomNumber, txtApartment, txtBillCode,
                txtBillType, txtDateExpired, txtBillTotal;
        private LinearLayout boderCardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtRoomNumber = itemView.findViewById(R.id.txtRoomNumber);
            txtApartment = itemView.findViewById(R.id.txtApartment);
            txtBillCode = itemView.findViewById(R.id.txtBillCode);
            txtBillType = itemView.findViewById(R.id.txtBillType);
            txtDateExpired = itemView.findViewById(R.id.txtDateExpired);
            txtBillTotal = itemView.findViewById(R.id.txtBillTotal);
            boderCardView = itemView.findViewById(R.id.borderCardView);
        }

        public TextView getTxtRoomNumber() {
            return txtRoomNumber;
        }

        public TextView getTxtApartment() {
            return txtApartment;
        }

        public TextView getTxtBillCode() {
            return txtBillCode;
        }

        public TextView getTxtBillType() {
            return txtBillType;
        }

        public TextView getTxtDateExpired() {
            return txtDateExpired;
        }

        public TextView getTxtBillTotal() {
            return txtBillTotal;
        }

        public LinearLayout getBoderCardView() {
            return boderCardView;
        }
    }
}
