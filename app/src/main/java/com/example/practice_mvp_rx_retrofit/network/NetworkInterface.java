package com.example.practice_mvp_rx_retrofit.network;

import com.example.practice_mvp_rx_retrofit.models.MovieResponse;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkInterface {

    @GET("discover/movie?api_key=")
    Observable<MovieResponse> getMoviesFromApi(@Query("api_key") String api_key);

    @GET("search/movie?api_key=")
    Observable<MovieResponse> getMoviesBasedOnQuery(@Query("api_key") String api_key, @Query("query") String q);

}
