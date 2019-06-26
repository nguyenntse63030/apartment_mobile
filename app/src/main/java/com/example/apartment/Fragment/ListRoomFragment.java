package com.example.apartment.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apartment.Activity.RoomDetailActivity;
import com.example.apartment.Adapter.ListRoomFragmentAdapter;
import com.example.apartment.Contract.ListRoomFragmentAdapterContract;
import com.example.apartment.Contract.ListRoomFragmentContract;
import com.example.apartment.Listener.Room_Listener;
import com.example.apartment.Model.Room;
import com.example.apartment.Presenter.ListRoomFragmentPresenterImpl;
import com.example.apartment.R;

import java.io.Serializable;

public class ListRoomFragment extends Fragment implements ListRoomFragmentContract.listRoomFragmentView, Room_Listener {
    private RecyclerView recyclerView;
    private ListRoomFragmentAdapter adapter;
    private ListRoomFragmentContract.listRoomFragmentPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ListRoomFragmentPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_room_fragment, container, false);
        recyclerView = view.findViewById(R.id.listRoomRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        presenter.loadListRoomData();
        return view;
    }

    @Override
    public void setAdapter(ListRoomFragmentAdapterContract.listRoomFragmentAdapterPresenter listNewsFragmentAdapterPresenter) {
        adapter = new ListRoomFragmentAdapter(listNewsFragmentAdapterPresenter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClickRoomItem(Room room) {
        Intent intent = new Intent(getContext(), RoomDetailActivity.class);
        intent.putExtra("room", (Serializable) room);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


}
