package com.davidpedroza.nanodegree.popularmovies;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by David on 16/08/2016.
 */
public class PopularMoviesApp extends Application {

    public static PopularMoviesService getPopularMoviesService() {
        return popularMoviesService;
    }

    private static PopularMoviesService popularMoviesService;

    @Override
    public void onCreate() {
        super.onCreate();
        createRetrofit();
    }

    private void createRetrofit () {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        popularMoviesService = retrofit.create(PopularMoviesService.class);

    }
}
