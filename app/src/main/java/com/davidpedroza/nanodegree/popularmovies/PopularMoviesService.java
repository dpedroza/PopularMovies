package com.davidpedroza.nanodegree.popularmovies;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by David on 16/08/2016.
 */
public interface PopularMoviesService {

    @GET("3/movie/popular?")
    Call<MoviesDBResponse> getMovies(@Query("api_key") String API_KEY);
}
