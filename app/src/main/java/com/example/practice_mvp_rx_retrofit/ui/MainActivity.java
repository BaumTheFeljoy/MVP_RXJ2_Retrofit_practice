package com.example.practice_mvp_rx_retrofit.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.practice_mvp_rx_retrofit.R;
import com.example.practice_mvp_rx_retrofit.adapters.MoviesAdapter;
import com.example.practice_mvp_rx_retrofit.models.MovieResponse;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    private String TAG = "MainActivity";
    RecyclerView.Adapter adapter;
    MainPresenter mainPresenter;
    RecyclerView rvMovies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife.bind(this); should be ok with viewbyid

        rvMovies = (RecyclerView)findViewById(R.id.rvMovies);

        setupMVP();
        setupViews();
        getMovieList();
    }


    private void setupMVP() {
        mainPresenter = new MainPresenter(this);
    }

    private void setupViews(){
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
            adapter = new MoviesAdapter(movieResponse.getResults(), MainActivity.this);
            rvMovies.setAdapter(adapter);
        }else{
            Log.d(TAG,"Movies response null");
        }
    }

    @Override
    public void displayError(String e) {
        showToast(e);
    }


}
