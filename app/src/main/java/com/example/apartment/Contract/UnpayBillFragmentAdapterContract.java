package com.example.apartment.Contract;

import com.example.apartment.Adapter.UnpayBillFragmentAdapter;

public class UnpayBillFragmentAdapterContract {
    public interface unpayBillFragmentAdapterPresenter{
        public void onBindViewHolder(UnpayBillFragmentAdapter.MyViewHolder holder, int position);
        public int returnListBillSize();
        public void onClickItemBill(int position);
    }
}
