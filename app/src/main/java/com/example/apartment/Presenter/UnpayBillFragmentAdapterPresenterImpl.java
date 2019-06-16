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
        holder.getTxtRoomNumber().setText("ROOM " + listBills.get(position).getRoom());
        holder.getTxtApartment().setText(listBills.get(position).getApartment());
        holder.getTxtBillCode().setText("Code: " + listBills.get(position).getCode());
        holder.getTxtBillType().setText("Type: " + listBills.get(position).getType());
        holder.getTxtDateExpired().setText("Date Expired: " + listBills.get(position).getDateExpired());
        holder.getTxtBillTotal().setText("Total: " + listBills.get(position).getCostTotal() + " VND");
    }

    @Override
    public int returnListBillSize() {
        return listBills.size();
    }

    @Override
    public void onClickItemBill(int position) {
        String code = listBills.get(position).getCode();
        String apartment = listBills.get(position).getApartment();
        String type = listBills.get(position).getType();
        String dateExpired = listBills.get(position).getDateExpired();

        int room = listBills.get(position).getRoom();
        float costTotal = listBills.get(position).getCostTotal();

        Bills bills = new Bills(code, type, dateExpired, apartment, room, costTotal);
        mCallback.onClickUnpayBillItem(bills);
    }
}
