package com.davidpedroza.nanodegree.popularmovies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by David on 16/08/2016.
 */
public class MoviesDBResponse {

    private int page;
    private List<Filme> results;
    @SerializedName("total_results") private int totalResults;
    @SerializedName("total_pages") private int totalPages;

    public int getPage() {
        return page;
    }

    public List<Filme> getResults() {
        return results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
