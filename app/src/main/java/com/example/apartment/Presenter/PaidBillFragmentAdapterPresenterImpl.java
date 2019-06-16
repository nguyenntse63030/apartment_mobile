package com.example.apartment.Presenter;

import com.example.apartment.Adapter.PaidBillFragmentAdapter;
import com.example.apartment.Contract.PaidBillFragmentAdapterContract;
import com.example.apartment.Listener.Paid_Bill_Listener;
import com.example.apartment.Model.Bills;
import com.example.apartment.R;

import java.util.List;

public class PaidBillFragmentAdapterPresenterImpl implements PaidBillFragmentAdapterContract.PaidBillFragmentAdapterPresenter {
    private List<Bills> listPaidBill;
    private Paid_Bill_Listener mCallback;

    public PaidBillFragmentAdapterPresenterImpl(List<Bills> listPaidBill, Paid_Bill_Listener mCallback) {
        this.listPaidBill = listPaidBill;
        this.mCallback = mCallback;
    }

    @Override
    public void onBindViewHolder(PaidBillFragmentAdapter.MyViewHolder holder, int position) {
        holder.getTxtRoomNumber().setText("ROOM " + listPaidBill.get(position).getRoom());
        holder.getTxtApartment().setText(listPaidBill.get(position).getApartment());
        holder.getTxtBillCode().setText("Code: " + listPaidBill.get(position).getCode());
        holder.getTxtBillType().setText("Type: " + listPaidBill.get(position).getType());
        holder.getTxtDateExpired().setText("Date Expired: " + listPaidBill.get(position).getDateExpired());
        holder.getTxtBillTotal().setText("Total: " + listPaidBill.get(position).getCostTotal() + " VND");
        holder.getBoderCardView().setBackgroundResource(R.drawable.border_paidbill_cardview);
    }

    @Override
    public void onClickPaidBillItem(int position) {
        String code = listPaidBill.get(position).getCode();
        String apartment = listPaidBill.get(position).getApartment();
        String type = listPaidBill.get(position).getType();
        String dateExpired = listPaidBill.get(position).getDateExpired();

        int room = listPaidBill.get(position).getRoom();
        float costTotal = listPaidBill.get(position).getCostTotal();

        Bills bills = new Bills(code, type, dateExpired, apartment, room, costTotal);
        mCallback.onClickPaidBillItem(bills);
    }

    @Override
    public int returnListPaidBillSize() {
        return listPaidBill.size();
    }
}
