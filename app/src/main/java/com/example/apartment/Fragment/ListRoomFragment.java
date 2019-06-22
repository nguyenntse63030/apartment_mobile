package com.example.apartment.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apartment.Adapter.ListRoomFragmentAdapter;
import com.example.apartment.Contract.ListRoomFragmentAdapterContract;
import com.example.apartment.Contract.ListRoomFragmentContract;
import com.example.apartment.Listener.Room_Listener;
import com.example.apartment.Model.Room;
import com.example.apartment.Presenter.ListRoomFragmentPresenterImpl;
import com.example.apartment.R;


public class ListRoomFragment extends Fragment implements ListRoomFragmentContract.listRoomFragmentView, Room_Listener {
    private RecyclerView recyclerView;
    private ListRoomFragmentAdapter adapter;
    private ListRoomFragmentContract.listRoomFragmentPresenter presenter;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ListRoomFragmentPresenterImpl(this);
        presenter.inputListRoomData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_room_fragment, container, false);
        recyclerView = view.findViewById(R.id.listRoomRecyclerView);
        presenter.createAdapter();

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void setAdapter(ListRoomFragmentAdapterContract.listRoomFragmentAdapterPresenter listNewsFragmentAdapterPresenter) {
        adapter = new ListRoomFragmentAdapter(listNewsFragmentAdapterPresenter);
    }

    @Override
    public void onClickRoomItem(Room room) {

    }
}
