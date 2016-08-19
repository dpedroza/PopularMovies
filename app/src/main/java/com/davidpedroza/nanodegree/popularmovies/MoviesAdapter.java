package com.davidpedroza.nanodegree.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by David on 17/08/2016.
 */
public class MoviesAdapter extends RecyclerView.Adapter<ViewHolder> {


        private Context context;
        private List<Filme> filmes;
        private AdapterInterface adapterInterface;

        public interface AdapterInterface {
            void onClickFoto(Filme filme);
        }

        public MoviesAdapter(Context context, List<Filme> filmes, AdapterInterface adapterInterface) {
            this.context = context;
            this.filmes = filmes;
            this.adapterInterface = adapterInterface;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final Filme filme = filmes.get(position);
            Picasso.with(context)
                    .load("http://image.tmdb.org/t/p/w185/" + filme.getPosterPath())
                    .into(holder.moviePicture);
            holder.moviePicture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adapterInterface.onClickFoto(filme);
                }
            });
        }

        @Override
        public int getItemCount() {
            return filmes.size();
        }


    }

