package com.example.practice_mvp_rx_retrofit.adapters;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practice_mvp_rx_retrofit.R;
import com.example.practice_mvp_rx_retrofit.models.Result;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private String TAG = "Adapter";
    List<Result> mResultList;

    public MoviesAdapter(List<Result> resultList) {
        this.mResultList = resultList;
    }

    //This gets called only as many times as we have cards in memory
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movies,parent,false);
        MovieViewHolder mh = new MovieViewHolder(v);
        return mh;
    }

    //This gets called all while scrolling to fill the cardviews with the information at the
    //corresponding position
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(mResultList.get(position));
        Log.d(TAG, "onBindViewHolder: movie bound at:" + position);
    }

    @Override
    public int getItemCount() {
        return mResultList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
