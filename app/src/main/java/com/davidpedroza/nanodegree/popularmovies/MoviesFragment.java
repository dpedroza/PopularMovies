package com.davidpedroza.nanodegree.popularmovies;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 15/08/2016.
 */
public class MoviesFragment extends Fragment implements MoviesAdapter.AdapterInterface {

    private static Activity activity;
    private List<Filme> filmes;
    private MoviesAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        activity = getActivity();

        ((MainActivity) activity).getPopularMovies(new RetrofitCallback() {
            @Override
            public void onSuccess(List<Filme> result) {
                if (result != null && result.size() > 0) {
                    filmes.clear();
                    filmes.addAll(result);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(String error) {
                Toast.makeText(getActivity(), "Erro no Fragment: " + error, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);

        filmes = new ArrayList<>();
        adapter = new MoviesAdapter(getActivity(), filmes, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return recyclerView;
    }

    @Override
    public void onClickFoto(Filme filme) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra("filme", filme);
        startActivity(intent);
    }

}
