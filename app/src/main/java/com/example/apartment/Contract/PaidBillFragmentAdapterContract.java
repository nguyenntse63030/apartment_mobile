package com.example.apartment.Contract;

import com.example.apartment.Adapter.PaidBillFragmentAdapter;
import com.example.apartment.Model.Bills;

import java.util.List;

public class PaidBillFragmentAdapterContract {
    public interface PaidBillFragmentAdapterPresenter{
        int returnListPaidBillSize();
        void onBindViewHolder(PaidBillFragmentAdapter.MyViewHolder holder, int position);
        void onClickPaidBillItem(int position);
        void setAdapter(PaidBillFragmentAdapter adapter);
        void filterList(List<Bills> filteredList);
    }
}
