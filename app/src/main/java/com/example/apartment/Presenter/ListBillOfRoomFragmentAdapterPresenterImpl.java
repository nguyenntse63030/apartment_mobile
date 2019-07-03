package com.example.apartment.Presenter;

import com.example.apartment.Adapter.ListBillOfRoomFragmentAdapter;
import com.example.apartment.Contract.ListBillOfRoomFragmentAdapterContract;
import com.example.apartment.Listener.List_Bill_Of_Room_Listener;
import com.example.apartment.Model.Bills;
import com.example.apartment.R;

import java.util.List;

public class ListBillOfRoomFragmentAdapterPresenterImpl implements ListBillOfRoomFragmentAdapterContract.ListBillOfRoomFragmentAdapterPresenter {
    private List<Bills> listBill;
    private List_Bill_Of_Room_Listener listener;

    public ListBillOfRoomFragmentAdapterPresenterImpl(List<Bills> listBill, List_Bill_Of_Room_Listener listener) {
        this.listBill = listBill;
        this.listener = listener;
    }

    @Override
    public int returnListBillSize() {
        return listBill.size();
    }

    @Override
    public void onBindViewHolder(ListBillOfRoomFragmentAdapter.MyViewHolder holder, int position) {
        holder.getTxtRoomNumber().setText("ROOM " + listBill.get(position).getRoom().getRoomNumber());
        holder.getTxtApartment().setText(listBill.get(position).getApartment().getName());
        holder.getTxtBillCode().setText("Code: " + listBill.get(position).getCode().substring(0,15));
        holder.getTxtBillType().setText("Type: " + listBill.get(position).getType());
        holder.getTxtDateExpired().setText("Date Expired: " + listBill.get(position).getExpiredTime());
        holder.getTxtBillTotal().setText("Total: " + listBill.get(position).getTotal() + " đ");
        holder.getBoderCardView().setBackgroundResource(R.drawable.border_paidbill_cardview);
    }

    @Override
    public void onClickBillItem(int position) {
        Bills bill = listBill.get(position);
        listener.onClickBillItem(bill);
    }
}
