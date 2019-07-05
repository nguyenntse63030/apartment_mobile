package com.example.apartment.Contract;

import android.content.Context;

import com.example.apartment.Adapter.PaidBillFragmentAdapter;
import com.example.apartment.Presenter.PaidBillFragmentAdapterPresenterImpl;
import com.google.android.material.textfield.TextInputEditText;

public class PaidBillFragmentContract {
    public interface paidBillFragmentPresenter{
        void inputListPaidBillData(Context context);
        void setAdapter(PaidBillFragmentAdapter adapter);
        void addActionSearch(TextInputEditText editSearch);
    }
    public interface paidBillFragmentView{
        void setAdapter(PaidBillFragmentAdapterPresenterImpl paidBillFragmentAdapterPresenter);
    }
}
