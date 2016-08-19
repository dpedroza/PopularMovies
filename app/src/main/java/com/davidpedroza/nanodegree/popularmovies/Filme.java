package com.davidpedroza.nanodegree.popularmovies;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by David on 16/08/2016.
 */
public class Filme implements Serializable {

    @SerializedName("poster_path") private String posterPath;
    private boolean adult;
    private String overview;
    @SerializedName("release_date") private String releaseDate;
    private long id;
    @SerializedName("original_title") private String originalTitle;
    @SerializedName("original_language") private String originalLanguage;
    private String title;
    @SerializedName("backdrop_path") private String backdropPath;
    private double popularity;
    @SerializedName("vote_count") private int voteCount;
    private boolean video;

    public double getVoteAverage() {
        return voteAverage;
    }

    public boolean isVideo() {
        return video;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public long getId() {
        return id;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getPosterPath() {
        return posterPath;
    }

    @SerializedName("vote_average") private double voteAverage;

}
