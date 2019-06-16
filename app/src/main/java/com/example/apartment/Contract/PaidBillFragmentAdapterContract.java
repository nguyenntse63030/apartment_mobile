package com.example.apartment.Contract;

import com.example.apartment.Adapter.PaidBillFragmentAdapter;

public class PaidBillFragmentAdapterContract {
    public interface PaidBillFragmentAdapterPresenter{
        public int returnListPaidBillSize();
        public void onBindViewHolder(PaidBillFragmentAdapter.MyViewHolder holder, int position);
        public void onClickPaidBillItem(int position);
    }
}
