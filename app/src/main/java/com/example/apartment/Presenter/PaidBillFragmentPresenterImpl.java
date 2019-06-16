package com.example.apartment.Presenter;

import com.example.apartment.Contract.PaidBillFragmentContract;
import com.example.apartment.Listener.Paid_Bill_Listener;
import com.example.apartment.Model.Bills;

import java.util.ArrayList;
import java.util.List;

public class PaidBillFragmentPresenterImpl implements PaidBillFragmentContract.paidBillFragmentPresenter {
    private PaidBillFragmentContract.paidBillFragmentView view;
    private List<Bills> listPaidBill = new ArrayList<>();
    private PaidBillFragmentAdapterPresenterImpl paidBillFragmentAdapterPresenter;

    public PaidBillFragmentPresenterImpl(PaidBillFragmentContract.paidBillFragmentView view) {
        this.view = view;
    }

    @Override
    public void createAdapter() {
        paidBillFragmentAdapterPresenter = new PaidBillFragmentAdapterPresenterImpl(listPaidBill, (Paid_Bill_Listener) view);
        view.setAdapter(paidBillFragmentAdapterPresenter);
    }

    @Override
    public void inputListPaidBillData() {
        listPaidBill.add(new Bills("WSD101-25", "Trung Nguyên",
                "12/06/2019", "Chung cu the Peak",
                101, 11000));

        listPaidBill.add(new Bills("WSD101-28", "Hữu Lễ",
                "13/06/2019", "Chung cu the Peak",
                102, 11000));

        listPaidBill.add(new Bills("WSD101-26", "Bảo Long",
                "14/06/2019", "Chung cu the Peak",
                104, 11000));

        listPaidBill.add(new Bills("WSD101-29", "Bình Minh",
                "15/06/2019", "Chung cu the Peak",
                201, 11000));

        listPaidBill.add(new Bills("WSD101-27", "Hoàng Nhân",
                "16/06/2019", "Chung cu the Peak",
                805, 11000));

        listPaidBill.add(new Bills("WSD101-30", "Duy Thắng",
                "17/06/2019", "Chung cu the Peak",
                51, 11000));

        listPaidBill.add(new Bills("WSD101-45", "Đức Toàn",
                "18/06/2019", "Chung cu the Peak",
                113, 11000));

        listPaidBill.add(new Bills("WSD101-55", "Bá Nam",
                "19/06/2019", "Chung cu the Peak",
                256, 11000));

        listPaidBill.add(new Bills("WSD101-63", "Kim Anh",
                "20/06/2019", "Chung cu the Peak",
                365, 11000));

        listPaidBill.add(new Bills("WSD101-70", "Cao Thư",
                "21/06/2019", "Chung cu the Peak",
                111, 11000));
    }
}
