package com.example.apartment.Contract;


import com.example.apartment.Presenter.UnpayBillFragmentAdapterPresenterImpl;

public class UnpayBillFragmentContract {
    public interface unpayBillFragmentPresenter{
        public void inputListUnpayBillData();
        public void createAdapter();
    }

    public interface unpayBillFragmentView{
        public void setAdapter(UnpayBillFragmentAdapterPresenterImpl unpayBillFragmentAdapterPresenter);
    }
}
