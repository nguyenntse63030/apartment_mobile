package com.example.apartment.Presenter;

import com.example.apartment.Contract.UnpayBillFragmentContract;
import com.example.apartment.Listener.Unpay_Bill_Listener;
import com.example.apartment.Model.Bills;

import java.util.ArrayList;
import java.util.List;

public class UnpayBillFragmentPresenterImpl implements UnpayBillFragmentContract.unpayBillFragmentPresenter {

    private UnpayBillFragmentContract.unpayBillFragmentView view;
    private List<Bills> listBills = new ArrayList<>();
    private UnpayBillFragmentAdapterPresenterImpl unpayBillFragmentAdapterPresenter;

    public UnpayBillFragmentPresenterImpl(UnpayBillFragmentContract.unpayBillFragmentView view) {
        this.view = view;
    }

    @Override
    public void inputListUnpayBillData(){
        listBills.add(new Bills("WSD101-25", "Electric",
                "12/06/2019", "Chung cu the Peak",
                101, 11000));

        listBills.add(new Bills("WSD101-28", "Water",
                "13/06/2019", "Chung cu the Peak",
                102, 11000));

        listBills.add(new Bills("WSD101-26", "Light",
                "14/06/2019", "Chung cu the Peak",
                104, 11000));

        listBills.add(new Bills("WSD101-29", "Electric",
                "15/06/2019", "Chung cu the Peak",
                201, 11000));

        listBills.add(new Bills("WSD101-27", "Water",
                "16/06/2019", "Chung cu the Peak",
                805, 11000));

        listBills.add(new Bills("WSD101-30", "Food",
                "17/06/2019", "Chung cu the Peak",
                51, 11000));

        listBills.add(new Bills("WSD101-45", "Light",
                "18/06/2019", "Chung cu the Peak",
                113, 11000));

        listBills.add(new Bills("WSD101-55", "Water",
                "19/06/2019", "Chung cu the Peak",
                256, 11000));

        listBills.add(new Bills("WSD101-63", "Light",
                "20/06/2019", "Chung cu the Peak",
                365, 11000));

        listBills.add(new Bills("WSD101-70", "Electric",
                "21/06/2019", "Chung cu the Peak",
                111, 11000));
    }

    @Override
    public void createAdapter(){
        unpayBillFragmentAdapterPresenter = new UnpayBillFragmentAdapterPresenterImpl(listBills, (Unpay_Bill_Listener) view);
        view.setAdapter(unpayBillFragmentAdapterPresenter);
    }
}
