package com.example.apartment.Presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.bumptech.glide.Glide;
import com.example.apartment.Activity.DepositAccountActivity;
import com.example.apartment.Api.UserApi;
import com.example.apartment.Contract.DepositAccountActivityContract;
import com.example.apartment.Global.GlobalValue;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.makeramen.roundedimageview.RoundedImageView;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class DepositAccountActivityPresenterImpl implements DepositAccountActivityContract.DepositAccountActivityPresenter {
    private UserApi userApi;
    private DepositAccountActivityContract.DepositAccountActivityView view;

    public DepositAccountActivityPresenterImpl(DepositAccountActivityContract.DepositAccountActivityView view) {
        this.view = view;
    }

    @Override
    public void fillData(Context context, RoundedImageView imgAvatar, TextInputEditText editAccount, TextInputEditText editCash) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("User",Context.MODE_PRIVATE);
        String urlPhoto = sharedPreferences.getString("photoURL","");
        int account = sharedPreferences.getInt("account",0);

        Glide.with(context).asBitmap().load(urlPhoto).into(imgAvatar);
        editAccount.setText(String.valueOf(account));
    }

    @Override
    public void depositAccount(final Context context, RoundedImageView imgAvatar, final TextInputEditText editAccount, TextInputEditText editCash) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("User",Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
        final int account = sharedPreferences.getInt("account",0);
        final int money = Integer.parseInt(editCash.getText().toString());
        final String token = sharedPreferences.getString("token","");

        userApi = GlobalValue.retrofit.create(UserApi.class);
        Map<String,String> data=new HashMap<>();
        data.put("money", String.valueOf(money));
        Call<JsonElement> call =userApi.depositAccount(token,data);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if (response.code()==200){
                    JsonElement responseData = response.body();
                    JsonParser parser = new JsonParser();
                    JsonObject responseObj = parser.parse(responseData.toString()).getAsJsonObject();
                    String message = responseObj.get("message").getAsString();

                    SharedPreferences.Editor editor = context.getSharedPreferences("User", MODE_PRIVATE).edit();
                    //add profile user
                    editor.putInt("account", account + money);
                    editAccount.setText(String.valueOf(account + money));

                    editor.apply();

                    view.showDialog(message);


                } else {
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
                System.out.println(t.getMessage());
            }
        });
    }

}
