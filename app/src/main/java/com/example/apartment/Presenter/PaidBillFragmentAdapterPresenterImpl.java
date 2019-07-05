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
    private PaidBillFragmentAdapter adapter;

    public PaidBillFragmentAdapterPresenterImpl(List<Bills> listPaidBill, Paid_Bill_Listener mCallback) {
        this.listPaidBill = listPaidBill;
        this.mCallback = mCallback;
    }

    @Override
    public void onBindViewHolder(PaidBillFragmentAdapter.MyViewHolder holder, int position) {
        holder.getTxtRoomNumber().setText("ROOM " + listPaidBill.get(position).getRoom().getRoomNumber());
        holder.getTxtApartment().setText(listPaidBill.get(position).getApartment().getName());
        holder.getTxtBillCode().setText("Code: " + listPaidBill.get(position).getCode().substring(0,15));
        holder.getTxtBillType().setText("Type: " + listPaidBill.get(position).getType());
        holder.getTxtDateExpired().setText("Date Expired: " + listPaidBill.get(position).getExpiredTime());
        holder.getTxtBillTotal().setText("Total: " + listPaidBill.get(position).getTotal() + " đ");
        holder.getBoderCardView().setBackgroundResource(R.drawable.border_paidbill_cardview);
    }

    @Override
    public void onClickPaidBillItem(int position) {
        Bills bills = listPaidBill.get(position);
        mCallback.onClickPaidBillItem(bills);
    }

    @Override
    public void setAdapter(PaidBillFragmentAdapter adapter) {
        this.adapter=adapter;
    }

    @Override
    public void filterList(List<Bills> filteredList) {
        listPaidBill = filteredList;
        adapter.notifyDataSetChanged();
    }

    @Override
    public int returnListPaidBillSize() {
        return listPaidBill.size();
    }
}
