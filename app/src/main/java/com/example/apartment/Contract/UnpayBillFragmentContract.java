package com.example.apartment.Contract;


import android.content.Context;

import com.example.apartment.Adapter.UnpayBillFragmentAdapter;
import com.example.apartment.Presenter.UnpayBillFragmentAdapterPresenterImpl;
import com.google.android.material.textfield.TextInputEditText;

public class UnpayBillFragmentContract {
    public interface unpayBillFragmentPresenter{
        void setAdapter(UnpayBillFragmentAdapter adapter);
        void addActionSearch(TextInputEditText editSearch);
        void inputListUnpayBillData(Context context);
    }

    public interface unpayBillFragmentView{
        void setAdapter(UnpayBillFragmentAdapterPresenterImpl unpayBillFragmentAdapterPresenter);
    }
}
