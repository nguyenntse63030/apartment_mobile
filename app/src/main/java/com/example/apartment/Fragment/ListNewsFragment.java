package com.example.apartment.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apartment.Adapter.ListNewsFragmentAdapter;
import com.example.apartment.Contract.ListNewsFragmentContract;
import com.example.apartment.Listener.List_News_Listener;
import com.example.apartment.Model.News;
import com.example.apartment.Presenter.ListNewsFragmentAdapterPresenterImpl;
import com.example.apartment.Presenter.ListNewsFragmentPresenterImpl;
import com.example.apartment.R;

public class ListNewsFragment extends Fragment implements ListNewsFragmentContract.listNewsFragmentView, List_News_Listener {
    private RecyclerView recyclerView;
    private ListNewsFragmentAdapter adapter;
    private ListNewsFragmentContract.listNewsFragmentPresenter presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ListNewsFragmentPresenterImpl(this);
        presenter.inputListNewsData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_news_fragment, container, false);
        recyclerView = view.findViewById(R.id.listNewsRecyclerView);
        presenter.createAdapter();
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onClickNewsItem(News news) {
        Toast.makeText(getContext(), news.getNewsTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setAdapter(ListNewsFragmentAdapterPresenterImpl listNewsFragmentAdapterPresenter) {
        adapter = new ListNewsFragmentAdapter(listNewsFragmentAdapterPresenter);
    }
}
