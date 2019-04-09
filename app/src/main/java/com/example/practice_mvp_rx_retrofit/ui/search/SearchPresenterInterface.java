package com.example.practice_mvp_rx_retrofit.ui.search;

import androidx.appcompat.widget.SearchView;

public interface SearchPresenterInterface {

    void getResultsBasedOnQuery(SearchView searchView);
}