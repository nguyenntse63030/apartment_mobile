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

import com.example.apartment.Adapter.PaidBillFragmentAdapter;
import com.example.apartment.Contract.PaidBillFragmentContract;
import com.example.apartment.Listener.Paid_Bill_Listener;
import com.example.apartment.Model.Bills;
import com.example.apartment.Presenter.PaidBillFragmentAdapterPresenterImpl;
import com.example.apartment.Presenter.PaidBillFragmentPresenterImpl;
import com.example.apartment.R;

public class PaidBillFragment extends Fragment implements PaidBillFragmentContract.paidBillFragmentView, Paid_Bill_Listener {
    private RecyclerView recyclerView;
    private PaidBillFragmentAdapter adapter;
    private PaidBillFragmentPresenterImpl presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PaidBillFragmentPresenterImpl(this);
        presenter.inputListPaidBillData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.paid_bill_fragment, container, false);
        recyclerView = view.findViewById(R.id.listPaidBillRecyclerView);
        presenter.createAdapter();
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onClickPaidBillItem(Bills bills) {
        Toast.makeText(getContext(), "Code: " + bills.getCode(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setAdapter(PaidBillFragmentAdapterPresenterImpl paidBillFragmentAdapterPresenter) {
        adapter = new PaidBillFragmentAdapter(paidBillFragmentAdapterPresenter);
    }
}
