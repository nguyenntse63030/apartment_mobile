package com.example.apartment.Contract;

import com.example.apartment.Adapter.ListBillOfRoomFragmentAdapter;

public class ListBillOfRoomFragmentAdapterContract {
    public interface ListBillOfRoomFragmentAdapterPresenter{
        public int returnListBillSize();
        public void onBindViewHolder(ListBillOfRoomFragmentAdapter.MyViewHolder holder, int position);
        public void onClickBillItem(int position);
    }
}
