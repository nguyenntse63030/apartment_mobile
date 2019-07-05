package com.example.apartment.Contract;

import com.example.apartment.Adapter.ListBillOfRoomFragmentAdapter;
import com.example.apartment.Adapter.ListRoomFragmentAdapter;
import com.example.apartment.Model.Bills;

import java.util.List;

public class ListBillOfRoomFragmentAdapterContract {
    public interface ListBillOfRoomFragmentAdapterPresenter{
        int returnListBillSize();
        void onBindViewHolder(ListBillOfRoomFragmentAdapter.MyViewHolder holder, int position);
        void onClickBillItem(int position);
        void setAdapter(ListBillOfRoomFragmentAdapter adapter);
        void filterList(List<Bills> filteredList);
    }
}
