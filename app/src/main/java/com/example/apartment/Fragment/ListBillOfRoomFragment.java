package com.example.apartment.Fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.apartment.Adapter.ListBillOfRoomFragmentAdapter;
import com.example.apartment.Adapter.PaidBillFragmentAdapter;
import com.example.apartment.Contract.ListBillOfRoomFragmentAdapterContract;
import com.example.apartment.Contract.ListBillOfRoomFragmentContract;
import com.example.apartment.Listener.List_Bill_Of_Room_Listener;
import com.example.apartment.Model.Bills;
import com.example.apartment.Model.Room;
import com.example.apartment.Presenter.ListBillOfRoomFragmentAdapterPresenterImpl;
import com.example.apartment.Presenter.ListBillOfRoomFragmentPresenterImpl;
import com.example.apartment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListBillOfRoomFragment extends Fragment implements ListBillOfRoomFragmentContract.listBillFragmentView, List_Bill_Of_Room_Listener {

    private RecyclerView recyclerView;
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
        View view = inflater.inflate(R.layout.paid_bill_fragment, container, false);
        recyclerView = view.findViewById(R.id.listPaidBillRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        return view;
    }

    @Override
    public void setAdapter(ListBillOfRoomFragmentAdapterContract.ListBillOfRoomFragmentAdapterPresenter listBillOfRoomFragmentAdapterPresenter) {
        adapter = new ListBillOfRoomFragmentAdapter(listBillOfRoomFragmentAdapterPresenter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClickBillItem(Bills bills) {
        Toast.makeText(getContext(), "Code: " + bills.getCode(), Toast.LENGTH_SHORT).show();
    }
}
