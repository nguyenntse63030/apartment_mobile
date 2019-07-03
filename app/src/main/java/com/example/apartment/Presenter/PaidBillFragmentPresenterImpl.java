package com.example.apartment.Presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.apartment.Api.BillApi;
import com.example.apartment.Contract.PaidBillFragmentContract;
import com.example.apartment.Global.GlobalValue;
import com.example.apartment.Listener.Paid_Bill_Listener;
import com.example.apartment.Model.Apartment;
import com.example.apartment.Model.Bills;
import com.example.apartment.Model.Room;
import com.example.apartment.Model.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaidBillFragmentPresenterImpl implements PaidBillFragmentContract.paidBillFragmentPresenter {
    private PaidBillFragmentContract.paidBillFragmentView view;
    private List<Bills> listPaidBill = new ArrayList<>();
    private PaidBillFragmentAdapterPresenterImpl paidBillFragmentAdapterPresenter;
    private BillApi billApi;

    public PaidBillFragmentPresenterImpl(PaidBillFragmentContract.paidBillFragmentView view) {
        this.view = view;
    }

    public void createAdapter() {
        paidBillFragmentAdapterPresenter = new PaidBillFragmentAdapterPresenterImpl(listPaidBill, (Paid_Bill_Listener) view);
        view.setAdapter(paidBillFragmentAdapterPresenter);
    }

    @Override
    public void inputListPaidBillData(Context context) {
        billApi = GlobalValue.retrofit.create(BillApi.class);
        SharedPreferences sharedPreferences = context.getSharedPreferences("User",Context.MODE_PRIVATE);
        String userId=sharedPreferences.getString("id","");
        getListBill(userId);
    }
    private void getListBill(String userId){
        if(listPaidBill != null){
            if(!listPaidBill.isEmpty()){
                listPaidBill.clear();
            }
        }
        try {
            Call<JsonElement> call =billApi.getPaidBill(userId);
            call.enqueue(new Callback<JsonElement>() {
                @Override
                public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                    JsonElement responseData = response.body();
                    JsonParser parser= new JsonParser();
                    JsonObject responseObj = parser.parse(responseData.toString()).getAsJsonObject();
                    JsonArray bills = responseObj.get("listBill").getAsJsonArray();

                    for (int i = 0;i < bills.size();i++){
                        JsonObject bill = bills.get(i).getAsJsonObject();
                        JsonObject user = bill.get("user").getAsJsonObject();
                        JsonObject manager = bill.get("manager").getAsJsonObject();
                        JsonObject apartment = bill.get("apartment").getAsJsonObject();
                        JsonObject room = bill.get("room").getAsJsonObject();

                        Gson gsonSP = new Gson();

                        User userObj=gsonSP.fromJson(user.toString(),User.class);
                        User managerObj=gsonSP.fromJson(manager.toString(),User.class);
                        Apartment apartmentObj=gsonSP.fromJson(apartment.toString(), Apartment.class);
//                        Room roomObj=gsonSP.fromJson(room,Room.class);
                        Room roomObj=new Room(room.get("_id").getAsString(),room.get("roomNumber").getAsString(),room.get("code").getAsString(),0,0,room.get("signDate").getAsString(),room.get("expiredDate").getAsString());
                        bill.remove("room");
                        Bills billObj=gsonSP.fromJson(bill.toString(),Bills.class);


                        billObj.setUser(userObj);
                        billObj.setManager(managerObj);
                        billObj.setApartment(apartmentObj);
                        billObj.setRoom(roomObj);
                        billObj.setCreateTime(GlobalValue.getDate(Long.parseLong(billObj.getCreatedTime())));
                        billObj.setExpiredTime(GlobalValue.getDate(Long.parseLong(billObj.getExpiredTime())));


                        listPaidBill.add(billObj);
                    }
                    createAdapter();
                }
                @Override
                public void onFailure(Call<JsonElement> call, Throwable t) {
                    System.out.println(t.getMessage());
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
