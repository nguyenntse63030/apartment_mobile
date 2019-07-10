package com.example.apartment.Presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.bumptech.glide.Glide;
import com.example.apartment.Api.UserApi;
import com.example.apartment.Contract.UpdateProfileActivityContract;
import com.example.apartment.Global.GlobalValue;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonElement;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class UpdateProfileActivityPresenterImpl implements UpdateProfileActivityContract.UpdateProfileActivityPresenter {
    private UpdateProfileActivityContract.UpdateProfileActivityView view;
    private UserApi userApi;

    public UpdateProfileActivityPresenterImpl(UpdateProfileActivityContract.UpdateProfileActivityView view) {
        this.view = view;
    }

    @Override
    public void fillData(Context context, RoundedImageView imgAvatar, TextInputEditText editName, TextInputEditText editGender, TextInputEditText editBirthDay) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("User",Context.MODE_PRIVATE);
        String urlPhoto = sharedPreferences.getString("photoURL","");
        String name = sharedPreferences.getString("name","");
        String gender = sharedPreferences.getString("gender","");
        String birthDayTimestamp=sharedPreferences.getString("birthDay","");
        String birthDay="";
        if (!birthDayTimestamp.isEmpty()){
            birthDay= GlobalValue.getDate(Long.parseLong(birthDayTimestamp));
        }
        Glide.with(context).asBitmap().load(urlPhoto).into(imgAvatar);
        editName.setText(name);
        editGender.setText(gender);
        editName.setText(name);
        editBirthDay.setText(birthDay);

    }

    @Override
    public void updateUser(final Context context, RoundedImageView imgAvatar, TextInputEditText editName, TextInputEditText editGender, TextInputEditText editBirthDay) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("User",Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
        final String name = editName.getText().toString().trim();
        final String gender = editGender.getText().toString().trim();
        String birthDate = editBirthDay.getText().toString().trim();
        final String birthDateTimestamp = GlobalValue.getTimestamp(birthDate);
        final String token = sharedPreferences.getString("token","");
        String userId = sharedPreferences.getString("id","");

        userApi = GlobalValue.retrofit.create(UserApi.class);
        Map<String,String> data=new HashMap<>();
        data.put("dateOfBirth", birthDateTimestamp);
        data.put("name", name);
        data.put("gender", gender);
        Call<JsonElement> call =userApi.updateUser(token,userId,data);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if (response.code()==200){
//                    JsonElement responseData = response.body();
//                    JsonParser parser = new JsonParser();
//                    JsonObject responseObj = parser.parse(responseData.toString()).getAsJsonObject();
//                    JsonObject user = responseObj.get("user").getAsJsonObject();
//                    String token = responseObj.get("token").getAsString();
//
//                    Gson gsonSP = new Gson();
//
//                    User userObj = gsonSP.fromJson(user.toString(), User.class);
                    SharedPreferences.Editor editor = context.getSharedPreferences("User", MODE_PRIVATE).edit();
                    //add profile user
                    editor.putString("name", name);
                    editor.putString("gender", gender);
                    editor.putString("birthDay", birthDateTimestamp);

                    editor.apply();
                    view.changePage();


                } else {
                    System.out.println(response);
                }
            }
            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
