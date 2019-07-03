package com.example.apartment.Presenter;

import com.example.apartment.Adapter.UnpayBillFragmentAdapter;
import com.example.apartment.Contract.UnpayBillFragmentAdapterContract;
import com.example.apartment.Listener.Unpay_Bill_Listener;
import com.example.apartment.Model.Bills;

import java.util.List;

public class UnpayBillFragmentAdapterPresenterImpl implements UnpayBillFragmentAdapterContract.unpayBillFragmentAdapterPresenter {
    List<Bills> listBills;
    Unpay_Bill_Listener mCallback;

    public UnpayBillFragmentAdapterPresenterImpl(List<Bills> listBills, Unpay_Bill_Listener mCallback) {
        this.listBills = listBills;
        this.mCallback = mCallback;
    }

    @Override
    public void onBindViewHolder(UnpayBillFragmentAdapter.MyViewHolder holder, int position) {
        holder.getTxtRoomNumber().setText("ROOM " + listBills.get(position).getRoom().getRoomNumber());
        holder.getTxtApartment().setText(listBills.get(position).getApartment().getName());
        holder.getTxtBillCode().setText("Code: " + listBills.get(position).getCode().substring(0,15));
        holder.getTxtBillType().setText("Type: " + listBills.get(position).getType());
        holder.getTxtDateExpired().setText("Date Expired: " + listBills.get(position).getExpiredTime());
        holder.getTxtBillTotal().setText("Total: " + listBills.get(position).getTotal() + " đ");
    }

    @Override
    public int returnListBillSize() {
        return listBills.size();
    }

    @Override
    public void onClickItemBill(int position) {


        Bills bill = listBills.get(position);
        mCallback.onClickUnpayBillItem(bill);
    }
}
