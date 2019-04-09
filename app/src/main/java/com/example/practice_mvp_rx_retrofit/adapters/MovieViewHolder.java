package com.example.practice_mvp_rx_retrofit.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.practice_mvp_rx_retrofit.R;
import com.example.practice_mvp_rx_retrofit.models.MovieResponse;
import com.example.practice_mvp_rx_retrofit.models.Result;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MovieViewHolder extends RecyclerView.ViewHolder {

    @NonNull
    private View rootView;

    @NonNull
    private TextView tvTitle;

    @NonNull
    private TextView tvOverview;

    @NonNull
    private TextView tvReleaseDate;

    @NonNull
    private ImageView ivMovie;

    //
    public MovieViewHolder(View v) {
        super(v);
        rootView = v;
        tvTitle = v.findViewById(R.id.tvTitle);
        tvOverview = v.findViewById(R.id.tvOverView);
        tvReleaseDate = v.findViewById(R.id.tvReleaseDate);
        ivMovie = v.findViewById(R.id.ivMovie);
    }
    
    public void bind(Result result){
        tvTitle.setText(result.getTitle());
        tvOverview.setText(result.getOverview());
        tvReleaseDate.setText(result.getReleaseDate());
        Glide.with(rootView.getContext()).load("https://image.tmdb.org/t/p/w500/"+result.getPosterPath()).into(ivMovie);
    }

}
