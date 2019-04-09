package com.example.practice_mvp_rx_retrofit.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.practice_mvp_rx_retrofit.R;
import com.example.practice_mvp_rx_retrofit.adapters.MoviesAdapter;
import com.example.practice_mvp_rx_retrofit.models.MovieResponse;
import com.example.practice_mvp_rx_retrofit.ui.search.SearchActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    Toolbar toolbar;

    private String TAG = "MainActivity";
    RecyclerView.Adapter adapter;
    MainPresenter mainPresenter;
    RecyclerView rvMovies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovies = findViewById(R.id.rvMovies);
        toolbar = findViewById(R.id.toolbar);

        setupMVP();
        setupViews();
        getMovieList();
    }


    private void setupMVP() {
        mainPresenter = new MainPresenter(this);
    }

    private void setupViews(){
//        setSupportActionBar(toolbar);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getMovieList() {
        mainPresenter.getMovies();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayMovies(MovieResponse movieResponse) {
        if(movieResponse!=null) {
            Log.d(TAG,movieResponse.getResults().get(1).getTitle());
            adapter = new MoviesAdapter(movieResponse.getResults());
            rvMovies.setAdapter(adapter);
        }else{
            Log.d(TAG,"Movies response null");
        }
    }

    @Override
    public void displayError(String e) {
        showToast(e);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.search){
            showToast("Search Clicked");
            Intent i = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
