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

import com.example.apartment.Activity.NewsDetailActivity;
import com.example.apartment.Adapter.ListNewsFragmentAdapter;
import com.example.apartment.Contract.ListNewsFragmentContract;
import com.example.apartment.Listener.List_News_Listener;
import com.example.apartment.Model.News;
import com.example.apartment.Presenter.ListNewsFragmentAdapterPresenterImpl;
import com.example.apartment.Presenter.ListNewsFragmentPresenterImpl;
import com.example.apartment.R;

import java.io.Serializable;

public class ListNewsFragment extends Fragment implements ListNewsFragmentContract.listNewsFragmentView, List_News_Listener {
    private RecyclerView recyclerView;
    private ListNewsFragmentAdapter adapter;
    private ListNewsFragmentContract.listNewsFragmentPresenter presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ListNewsFragmentPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_news_fragment, container, false);
        recyclerView = view.findViewById(R.id.listNewsRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        presenter.loadListNewsData(getActivity().getApplicationContext());
        return view;
    }

    @Override
    public void onClickNewsItem(News news) {
        Intent intent = new Intent(getContext(), NewsDetailActivity.class);
        intent.putExtra("news", (Serializable) news);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void setAdapter(ListNewsFragmentAdapterPresenterImpl listNewsFragmentAdapterPresenter) {
        adapter = new ListNewsFragmentAdapter(listNewsFragmentAdapterPresenter, getContext());
        recyclerView.setAdapter(adapter);
    }

}
