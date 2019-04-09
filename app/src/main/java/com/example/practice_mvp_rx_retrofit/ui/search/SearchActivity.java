package com.example.practice_mvp_rx_retrofit.ui.search;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.practice_mvp_rx_retrofit.R;
import com.example.practice_mvp_rx_retrofit.adapters.MoviesAdapter;
import com.example.practice_mvp_rx_retrofit.models.MovieResponse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SearchActivity extends AppCompatActivity implements SearchViewInterface {

    RecyclerView rvQueryResult;

    private SearchView searchView;
    SearchPresenter searchPresenter;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        rvQueryResult = findViewById(R.id.rvQueryResult);

        setupViews();
        setupMVP();
    }

    private void setupViews() {

        rvQueryResult.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupMVP(){
        searchPresenter = new SearchPresenter(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_search,menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Enter Movie name..");

        searchPresenter.getResultsBasedOnQuery(searchView);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.action_search){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(SearchActivity.this,str,Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayResult(MovieResponse movieResponse) {
        adapter = new MoviesAdapter(movieResponse.getResults());
        rvQueryResult.setAdapter(adapter);
    }

    @Override
    public void displayError(String s) {
        showToast(s);
    }
}
