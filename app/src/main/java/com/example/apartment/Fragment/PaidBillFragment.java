package com.example.apartment.Fragment;

import android.content.Intent;
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

import com.example.apartment.Activity.BillDetailActivity;
import com.example.apartment.Adapter.PaidBillFragmentAdapter;
import com.example.apartment.Contract.PaidBillFragmentContract;
import com.example.apartment.Listener.Paid_Bill_Listener;
import com.example.apartment.Model.Bills;
import com.example.apartment.Presenter.PaidBillFragmentAdapterPresenterImpl;
import com.example.apartment.Presenter.PaidBillFragmentPresenterImpl;
import com.example.apartment.R;
import com.google.android.material.textfield.TextInputEditText;

public class PaidBillFragment extends Fragment implements PaidBillFragmentContract.paidBillFragmentView, Paid_Bill_Listener {
    private RecyclerView recyclerView;
    private TextInputEditText editSearch;
    private PaidBillFragmentAdapter adapter;
    private PaidBillFragmentPresenterImpl presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PaidBillFragmentPresenterImpl(this);
        presenter.inputListPaidBillData(getActivity().getApplicationContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.paid_bill_fragment, container, false);
        recyclerView = view.findViewById(R.id.listPaidBillRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        editSearch = view.findViewById(R.id.editPaidBillSearch);
        presenter.addActionSearch(editSearch);
        return view;
    }

    @Override
    public void onClickPaidBillItem(Bills bill) {
        Intent intent = new Intent(getContext(), BillDetailActivity.class);
        intent.putExtra("bill",bill);
        startActivity(intent);
    }

    @Override
    public void setAdapter(PaidBillFragmentAdapterPresenterImpl paidBillFragmentAdapterPresenter) {
        adapter = new PaidBillFragmentAdapter(paidBillFragmentAdapterPresenter);
        presenter.setAdapter(adapter);
        recyclerView.setAdapter(adapter);
    }
}
