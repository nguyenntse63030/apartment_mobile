package com.example.apartment.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apartment.Activity.BillDetailActivity;
import com.example.apartment.Adapter.ListBillOfRoomFragmentAdapter;
import com.example.apartment.Contract.ListBillOfRoomFragmentAdapterContract;
import com.example.apartment.Contract.ListBillOfRoomFragmentContract;
import com.example.apartment.Listener.List_Bill_Of_Room_Listener;
import com.example.apartment.Model.Bills;
import com.example.apartment.Model.Room;
import com.example.apartment.Presenter.ListBillOfRoomFragmentPresenterImpl;
import com.example.apartment.R;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListBillOfRoomFragment extends Fragment implements ListBillOfRoomFragmentContract.listBillFragmentView, List_Bill_Of_Room_Listener {

    private RecyclerView recyclerView;
    private TextInputEditText editSearch;
    private ListBillOfRoomFragmentAdapter adapter;
    private ListBillOfRoomFragmentContract.listBillFragmentPresenter presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ListBillOfRoomFragmentPresenterImpl(this);
        Room room = (Room) getActivity().getIntent().getSerializableExtra("room");
        presenter.loadListBillData(room.getId());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_bill_of_room, container, false);
        recyclerView = view.findViewById(R.id.listBillOfRoomRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        //add action cho editSearch
        editSearch = view.findViewById(R.id.editBillOfRoomSearch);
        presenter.addActionSearch(editSearch);

        return view;
    }

    @Override
    public void setAdapter(ListBillOfRoomFragmentAdapterContract.ListBillOfRoomFragmentAdapterPresenter listBillOfRoomFragmentAdapterPresenter) {
        adapter = new ListBillOfRoomFragmentAdapter(listBillOfRoomFragmentAdapterPresenter);
        presenter.setAdapter(adapter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClickBillItem(Bills bill) {
        Intent intent = new Intent(getContext(), BillDetailActivity.class);
        intent.putExtra("bill",bill);
        startActivity(intent);
    }
}
