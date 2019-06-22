package com.example.apartment.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apartment.Contract.ListRoomFragmentAdapterContract;
import com.example.apartment.R;

public class ListRoomFragmentAdapter extends RecyclerView.Adapter<ListRoomFragmentAdapter.MyViewHolder>{

    private ListRoomFragmentAdapterContract.listRoomFragmentAdapterPresenter presenter;

    public ListRoomFragmentAdapter(ListRoomFragmentAdapterContract.listRoomFragmentAdapterPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_room, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        presenter.onBindViewHolder(holder,position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickItemRoom(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return presenter.returnListRoomSize();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView lbRoomNumber, txtApartment, txtRoomID,
                txtRoomNumber,txtSignDate,txtDistrict,txtAddress,txtUnpayBillNumber;

        public MyViewHolder(@NonNull View view) {
            super(view);
            lbRoomNumber = view.findViewById(R.id.lbRoomNumber);
            txtApartment = view.findViewById(R.id.txtApartment);
            txtRoomID = view.findViewById(R.id.txtRoomID);
            txtRoomNumber = view.findViewById(R.id.txtRoomNumber);
            txtSignDate = view.findViewById(R.id.txtSignDate);
            txtDistrict = view.findViewById(R.id.txtDistrict);
            txtAddress = view.findViewById(R.id.txtAddress);
            txtUnpayBillNumber = view.findViewById(R.id.txtUnpayBillNumber);
        }

        public TextView getLbRoomNumber() {
            return lbRoomNumber;
        }

        public TextView getTxtApartment() {
            return txtApartment;
        }

        public TextView getTxtRoomID() {
            return txtRoomID;
        }

        public TextView getTxtRoomNumber() {
            return txtRoomNumber;
        }

        public TextView getTxtSignDate() {
            return txtSignDate;
        }

        public TextView getTxtDistrict() {
            return txtDistrict;
        }

        public TextView getTxtAddress() {
            return txtAddress;
        }

        public TextView getTxtUnpayBillNumber() {
            return txtUnpayBillNumber;
        }
    }
}
