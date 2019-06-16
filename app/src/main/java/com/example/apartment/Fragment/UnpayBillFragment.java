package com.example.apartment.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apartment.Adapter.UnpayBillFragmentAdapter;
import com.example.apartment.Contract.UnpayBillFragmentContract;
import com.example.apartment.Listener.Unpay_Bill_Listener;
import com.example.apartment.Model.Bills;
import com.example.apartment.Presenter.UnpayBillFragmentAdapterPresenterImpl;
import com.example.apartment.Presenter.UnpayBillFragmentPresenterImpl;
import com.example.apartment.R;


public class UnpayBillFragment extends Fragment implements UnpayBillFragmentContract.unpayBillFragmentView, Unpay_Bill_Listener {
    private UnpayBillFragmentAdapter adapter;
    private RecyclerView recyclerView;
    private UnpayBillFragmentPresenterImpl presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new UnpayBillFragmentPresenterImpl(this);
        presenter.inputListUnpayBillData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.unpay_bill_fragment, container, false);
        recyclerView = view.findViewById(R.id.listUnpayBillRecyclerView);
        presenter.createAdapter();
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onClickUnpayBillItem(Bills bills) {
        Toast.makeText(getContext(), "Code: " + bills.getCode(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setAdapter(UnpayBillFragmentAdapterPresenterImpl unpayBillFragmentAdapterPresenter) {
        adapter = new UnpayBillFragmentAdapter(unpayBillFragmentAdapterPresenter);
    }
}
