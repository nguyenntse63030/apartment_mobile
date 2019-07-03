package com.example.apartment.Contract;


import android.content.Context;

import com.example.apartment.Presenter.UnpayBillFragmentAdapterPresenterImpl;

public class UnpayBillFragmentContract {
    public interface unpayBillFragmentPresenter{
        public void inputListUnpayBillData(Context context);
    }

    public interface unpayBillFragmentView{
        public void setAdapter(UnpayBillFragmentAdapterPresenterImpl unpayBillFragmentAdapterPresenter);
    }
}
