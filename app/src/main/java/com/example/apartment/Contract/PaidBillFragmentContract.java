package com.example.apartment.Contract;

import com.example.apartment.Presenter.PaidBillFragmentAdapterPresenterImpl;

public class PaidBillFragmentContract {
    public interface paidBillFragmentPresenter{
        public void createAdapter();
        public void inputListPaidBillData();
    }
    public interface paidBillFragmentView{
        public void setAdapter(PaidBillFragmentAdapterPresenterImpl paidBillFragmentAdapterPresenter);
    }
}
