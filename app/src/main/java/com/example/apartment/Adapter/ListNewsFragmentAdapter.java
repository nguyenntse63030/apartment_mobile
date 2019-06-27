package com.example.apartment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apartment.Presenter.ListNewsFragmentAdapterPresenterImpl;
import com.example.apartment.R;

public class ListNewsFragmentAdapter extends RecyclerView.Adapter<ListNewsFragmentAdapter.MyViewHolder>{
    private ListNewsFragmentAdapterPresenterImpl presenter;
    private Context context;

    public ListNewsFragmentAdapter(ListNewsFragmentAdapterPresenterImpl presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_news, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        presenter.onBindViewHolder(holder, position, context);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickItemNews(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return presenter.returnListNewsSize();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView newsImage;
        private TextView txtNewsTitle, txtNewsDescription, txtDateOfNews;

        public MyViewHolder(@NonNull View view) {
            super(view);
            newsImage = view.findViewById(R.id.newsImage);
            txtNewsTitle = view.findViewById(R.id.txtNewsTitle);
            txtNewsDescription = view.findViewById(R.id.txtNewsDescription);
            txtDateOfNews = view.findViewById(R.id.txtDateOfNews);
        }

        public ImageView getNewsImage() {
            return newsImage;
        }

        public TextView getTxtNewsTitle() {
            return txtNewsTitle;
        }

        public TextView getTxtNewsDescription() {
            return txtNewsDescription;
        }

        public TextView getTxtDateOfNews() {
            return txtDateOfNews;
        }
    }
}
