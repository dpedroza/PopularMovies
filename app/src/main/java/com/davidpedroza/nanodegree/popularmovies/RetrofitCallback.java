package com.davidpedroza.nanodegree.popularmovies;

import java.util.List;

/**
 * Created by David on 16/08/2016.
 */
public interface RetrofitCallback {
    void onSuccess(List<Filme> result);
    void onError(String error);
}
