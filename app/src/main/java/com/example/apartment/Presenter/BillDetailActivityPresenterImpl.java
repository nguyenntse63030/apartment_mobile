package com.example.apartment.Presenter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apartment.Activity.BillDetailActivity;
import com.example.apartment.Api.BillApi;
import com.example.apartment.Contract.BillDetailActivityContract;
import com.example.apartment.Global.GlobalValue;
import com.example.apartment.Model.Bills;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class BillDetailActivityPresenterImpl implements BillDetailActivityContract.BillDetailActivityPresenter {
    private BillApi billApi;
    private BillDetailActivityContract.BillDetailActivityView view;

    public BillDetailActivityPresenterImpl(BillDetailActivity view) {
        this.view = view;
    }

    @Override
    public void fillData(Intent intent, TextView txtBillCode, TextView txtType, TextView txtRoomCode,
                         TextView txtRoomNumber, TextView txtApartment, TextView txtCreateDate,
                         TextView txtExpireDate, TextView txtOldNumber, TextView txtNewNumber,
                         TextView txtUsedNumber, TextView txtTotal, TextView txtStatus, Button btnPay, final Context context,
                         TextView lbOldNumber,TextView lbNewNumber,TextView lbUsedNumber) {
        final Bills bill = (Bills) intent.getSerializableExtra("bill");
        txtBillCode.setText(bill.getCode());
        txtType.setText(bill.getType());
        txtRoomCode.setText(bill.getRoom().getCode());
        txtRoomNumber.setText(bill.getRoom().getRoomNumber());
        txtApartment.setText(bill.getApartment().getName());
        txtCreateDate.setText(bill.getCreatedTime());
        txtExpireDate.setText(bill.getExpiredTime());
        if (bill.getType().equalsIgnoreCase("Service")){
            txtOldNumber.setVisibility(View.INVISIBLE);
            txtNewNumber.setVisibility(View.INVISIBLE);
            txtUsedNumber.setVisibility(View.INVISIBLE);
            lbOldNumber.setVisibility(View.INVISIBLE);
            lbNewNumber.setVisibility(View.INVISIBLE);
            lbUsedNumber.setVisibility(View.INVISIBLE);
        }else{
            txtOldNumber.setText(String.valueOf(bill.getOldNumber()));
            txtNewNumber.setText(String.valueOf(bill.getNewNumber()));
            txtUsedNumber.setText(String.valueOf(bill.getUsedNumber()));
        }

//        String.valueOf(bill.getTotal())
        txtTotal.setText(String.format("%,d",bill.getTotal())+ " đ");

        txtStatus.setText(bill.getStatus());
        if (bill.getStatus().equalsIgnoreCase("PAID")){
            btnPay.setVisibility(View.INVISIBLE);
        }else {
            btnPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    view.showDialogConfirm();
                }
            });
        }

    }

    @Override
    public void payBill(Intent intent, final Button btnPay, final Context context, final TextView txtStatus) {
        final Bills bill = (Bills) intent.getSerializableExtra("bill");
        billApi = GlobalValue.retrofit.create(BillApi.class);
        SharedPreferences preferences = context.getSharedPreferences("User",Context.MODE_PRIVATE);
        String token = preferences.getString("token","");
        Call<JsonElement> call = billApi.payBill(token,bill.getId());
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if(response.code() == 200){
                    JsonElement responseData = response.body();
                    JsonParser parser = new JsonParser();
                    JsonObject responseObj = parser.parse(responseData.toString()).getAsJsonObject();
                    String message = responseObj.get("message").getAsString();
                    int beforeTrans = responseObj.get("beforeTrans").getAsInt();
                    int afterTrans = responseObj.get("afterTrans").getAsInt();

                    SharedPreferences.Editor editor = context.getSharedPreferences("User", MODE_PRIVATE).edit();
                    editor.putInt("account",afterTrans);

                    editor.apply();

                    view.showDialog(message+". Số tiền còn lại trong tài khoản là: "+ afterTrans + " đ");
                    btnPay.setVisibility(View.INVISIBLE);
                    txtStatus.setText("PAID");

                }else{
                    try {
                        JSONObject errorBody=new JSONObject(response.errorBody().string());
                        Toast.makeText(context, errorBody.getString("errorMessage"), Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {

            }
        });
    }

}
