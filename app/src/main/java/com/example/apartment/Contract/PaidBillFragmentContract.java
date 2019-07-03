package com.example.apartment.Contract;

import android.content.Context;

import com.example.apartment.Presenter.PaidBillFragmentAdapterPresenterImpl;

public class PaidBillFragmentContract {
    public interface paidBillFragmentPresenter{
        public void inputListPaidBillData(Context context);
    }
    public interface paidBillFragmentView{
        public void setAdapter(PaidBillFragmentAdapterPresenterImpl paidBillFragmentAdapterPresenter);
    }
}
