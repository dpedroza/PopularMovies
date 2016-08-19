package com.davidpedroza.nanodegree.popularmovies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by David on 18/08/2016.
 */
//ViewHolder
class ViewHolder extends RecyclerView.ViewHolder  {

    public ImageView moviePicture;

    public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_movie, parent, false));
        moviePicture = (ImageView) itemView.findViewById(R.id.movie_picture);
    }


}
