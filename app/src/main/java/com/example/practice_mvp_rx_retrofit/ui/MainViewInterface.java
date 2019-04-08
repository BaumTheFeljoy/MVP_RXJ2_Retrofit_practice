package com.example.practice_mvp_rx_retrofit.ui;

import com.example.practice_mvp_rx_retrofit.models.MovieResponse;

public interface MainViewInterface {

    void showToast(String s);

    void displayMovies(MovieResponse movieResponse);

    void displayError(String s);
}