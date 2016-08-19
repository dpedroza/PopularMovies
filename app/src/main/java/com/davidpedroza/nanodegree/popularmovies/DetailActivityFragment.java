package com.davidpedroza.nanodegree.popularmovies;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private TextView title;
    private ImageView poster;
    private TextView overview;
    private Filme mFilme;

    public DetailActivityFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().getIntent().getExtras();

        Bundle intent = getActivity().getIntent().getExtras();

        mFilme = (Filme) intent.get("filme");
        title.setText(mFilme.getTitle());
        overview.setText(mFilme.getOverview());

        Picasso.with(getActivity()).load("http://image.tmdb.org/t/p/w185/" + mFilme.getPosterPath()).into(poster);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        title = (TextView) rootView.findViewById(R.id.title);
        poster = (ImageView) rootView.findViewById(R.id.poster);
        overview = (TextView) rootView.findViewById(R.id.description);

        return rootView;
    }
}
