package com.example.apartment.Presenter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.apartment.Api.UserApi;
import com.example.apartment.Contract.LoginActivityContract;
import com.example.apartment.Global.GlobalValue;
import com.example.apartment.Model.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class LoginActivityPresenterImpl implements LoginActivityContract.LoginActivityPresenter {
    private UserApi userApi;
    private LoginActivityContract.LoginActivityView view;

    public LoginActivityPresenterImpl(LoginActivityContract.LoginActivityView view) {
        this.view = view;
    }

    @Override
    public void login(TextInputEditText editPhone, TextInputEditText editPassword, final Context context) {
        try {
            String phone = editPhone.getText().toString();
            String password = editPassword.getText().toString();
            userApi = GlobalValue.retrofit.create(UserApi.class);
//            JSONObject paramObj = new JSONObject();
//            paramObj.put("phone", phone);
//            paramObj.put("password", password);
            Map<String,String> data=new HashMap<>();
            data.put("phone", phone);
            data.put("password", password);
            Call<JsonElement> call =userApi.verify(data);
            call.enqueue(new Callback<JsonElement>() {
                @Override
                public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                    JsonElement responseData = response.body();
                    JsonParser parser= new JsonParser();
                    JsonObject responseObj = parser.parse(responseData.toString()).getAsJsonObject();
                    if (responseObj.has("user")){
                        JsonObject user = responseObj.get("user").getAsJsonObject();
                        String token = responseObj.get("token").getAsString();

                        Gson gsonSP = new Gson();

                        User userObj=gsonSP.fromJson(user.toString(),User.class);
                        SharedPreferences.Editor editor = context.getSharedPreferences("User", MODE_PRIVATE).edit();
                        //add token
                        editor.putString("token", token);
                        //add profile user
                        editor.putString("name", userObj.getName());
                        editor.putString("id", userObj.getId());
                        editor.putString("gender", userObj.getGender());
                        editor.putString("mail", userObj.getEmail());
                        editor.putString("phone", userObj.getPhone());
                        editor.putString("birthDay", userObj.getDateOfBirth());
                        editor.putString("address", userObj.getAddress());
                        editor.putString("code", userObj.getCode());
                        editor.putString("createTime", userObj.getCreatedTime());
                        editor.putString("photoURL", userObj.getPhotoURL());

                        editor.apply();
                        view.changePage();


                    }else {
                        System.out.println(response);
                    }

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
