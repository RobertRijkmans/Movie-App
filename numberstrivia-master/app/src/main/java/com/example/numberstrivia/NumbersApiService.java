package com.example.numberstrivia;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NumbersApiService {

    @GET("3/discover/movie?api_key=03700f3f0e7dc12e6b8e9943ca85d212&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&primary_release_year=")
    Call<Movies> getMovieList(@Query("year") int year);

}

