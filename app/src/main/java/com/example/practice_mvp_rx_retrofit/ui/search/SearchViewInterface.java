package com.example.practice_mvp_rx_retrofit.ui.search;

import com.example.practice_mvp_rx_retrofit.models.MovieResponse;

public interface SearchViewInterface {

    void showToast(String str);
    void displayResult(MovieResponse movieResponse);
    void displayError(String s);
}