package com.davidpedroza.nanodegree.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "a74447a1a791fa7d543f65014e25af43";
    private PopularMoviesService popularMoviesService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

    public void getPopularMovies (final RetrofitCallback retrofitCallback) {

        popularMoviesService = PopularMoviesApp.getPopularMoviesService();
        popularMoviesService.getMovies(API_KEY).enqueue(new Callback<MoviesDBResponse>() {
            @Override
            public void onResponse(Call<MoviesDBResponse> call, retrofit2.Response<MoviesDBResponse> response) {
                if (response.isSuccessful()) {
                    List<Filme> filmes = response.body().getResults();
                    retrofitCallback.onSuccess(filmes);
                }
            }

            @Override
            public void onFailure(Call<MoviesDBResponse> call, Throwable t) {
                retrofitCallback.onError(t.getMessage());
            }
        });

    }


}
