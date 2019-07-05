package com.example.apartment.Contract;

import com.example.apartment.Adapter.UnpayBillFragmentAdapter;
import com.example.apartment.Model.Bills;

import java.util.List;

public class UnpayBillFragmentAdapterContract {
    public interface unpayBillFragmentAdapterPresenter{
        void onBindViewHolder(UnpayBillFragmentAdapter.MyViewHolder holder, int position);
        int returnListBillSize();
        void onClickItemBill(int position);
        void setAdapter(UnpayBillFragmentAdapter adapter);
        void filterList(List<Bills> filteredList);
    }
}
