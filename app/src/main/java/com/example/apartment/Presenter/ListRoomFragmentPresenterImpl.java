package com.example.apartment.Presenter;



import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.apartment.Adapter.ListRoomFragmentAdapter;
import com.example.apartment.Api.RoomApi;
import com.example.apartment.Contract.ListRoomFragmentAdapterContract;
import com.example.apartment.Contract.ListRoomFragmentContract;
import com.example.apartment.Global.GlobalValue;
import com.example.apartment.Listener.Room_Listener;
import com.example.apartment.Model.Apartment;
import com.example.apartment.Model.Room;
import com.example.apartment.Model.User;
import com.google.android.material.textfield.TextInputEditText;
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

public class ListRoomFragmentPresenterImpl implements ListRoomFragmentContract.listRoomFragmentPresenter {
    private List<Room> listRoom = new ArrayList<>();
    private ListRoomFragmentContract.listRoomFragmentView view;
    //adapter dùng để thao tác khi người dùng search(không dùng adapter Presenter để thoa tác dc)
    private ListRoomFragmentAdapter adapter;

    private RoomApi roomApi;
    //presenter của adapter
    private ListRoomFragmentAdapterContract.listRoomFragmentAdapterPresenter adapterPresenter;

    public ListRoomFragmentPresenterImpl(ListRoomFragmentContract.listRoomFragmentView view) {
        this.view = view;
    }
    @Override
    public void setAdapter(ListRoomFragmentAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void addActionSearch(TextInputEditText editSearch){
        //add actionText changed listener
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }
    //sau khi thay đổi edit text search set lại adapter
    private void filter(String text){
        List<Room> filteredList = new ArrayList<>();
        for (Room room:listRoom ) {
            if (room.getCode().toLowerCase().contains(text.toLowerCase().trim())||room.getApartment().getName().toLowerCase().contains(text.toLowerCase().trim())){
                filteredList.add(room);
            }
        }
        adapterPresenter.setAdapter(adapter);
        adapterPresenter.filterList(filteredList);
    }
    //@Override
    private void createAdapter() {
        adapterPresenter = new ListRoomFragmentAdapterPresenterImpl(listRoom, (Room_Listener) view,adapter);
        view.setAdapter(adapterPresenter);
    }

    @Override
    public void loadListRoomData(Context context) {
        roomApi = GlobalValue.retrofit.create(RoomApi.class);
        SharedPreferences sharedPreferences = context.getSharedPreferences("User",Context.MODE_PRIVATE);
        String userId=sharedPreferences.getString("id","");
        getListRoom(userId);
    }
    private void getListRoom(String userId){
        if(listRoom != null){
            if(!listRoom.isEmpty()){
                listRoom.clear();
            }
        }
        try {
            Call<JsonElement> call =roomApi.getRoomByUser(userId);
            call.enqueue(new Callback<JsonElement>() {
                @Override
                public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                    JsonElement responseData = response.body();
                    JsonParser parser= new JsonParser();
                    JsonObject responseObj = parser.parse(responseData.toString()).getAsJsonObject();
                    JsonArray rooms = responseObj.get("listRoom").getAsJsonArray();

                    for (int i = 0;i < rooms.size();i++){
                        JsonObject room = rooms.get(i).getAsJsonObject();
                        JsonObject user = room.get("user").getAsJsonObject();
                        JsonObject apartment = room.get("apartment").getAsJsonObject();

                        Gson gsonSP = new Gson();

                        User userObj=gsonSP.fromJson(user.toString(),User.class);
                        Apartment apartmentObj=gsonSP.fromJson(apartment.toString(), Apartment.class);
                        Room roomObj=gsonSP.fromJson(room.toString(),Room.class);

                        roomObj.setUser(userObj);
                        roomObj.setApartment(apartmentObj);
                        roomObj.setSignDate(GlobalValue.getDate(Long.parseLong(roomObj.getSignDate())));

                        if (!roomObj.getExpiredDate().equals("0"))
                        {
                            roomObj.setExpiredDate(GlobalValue.getDate(Long.parseLong(roomObj.getExpiredDate())));
                        }
                        listRoom.add(roomObj);
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
