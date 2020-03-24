package com.example.pokedex;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StarwarsAdapter extends   RecyclerView.Adapter<StarwarsViewHolder>{
    private List<FilmsModel> mFilms;
    private List<PeopleModel> mPeople;

    public StarwarsAdapter(List<FilmsModel> films){
        mFilms = films;
        Log.d("MODELS: ", String.valueOf(films));
    }



    @NonNull
    @Override
    public StarwarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.film_item, parent, false);
        return new StarwarsViewHolder(v);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull StarwarsViewHolder holder, int position) {
        // Get the data model based on position
        FilmsModel filmModel = mFilms.get(position);
        Log.d("MODEL:::++++++++++++++++++++ ", String.valueOf(filmModel.title));

        // Set item views based on your views and data model
        TextView titleView = holder.filmTitle;
        titleView.setText(filmModel.getTitle());

        TextView episodeView = holder.episode;
        episodeView.setText(filmModel.getEpisode_id());

        TextView directorView = holder.director;
        directorView.setText(filmModel.getDirector());

        TextView producerView = holder.producer;
        producerView.setText(filmModel.getProducer());

        TextView releaseView = holder.release;
        releaseView.setText(filmModel.getReleaseDate());
    }

    @Override
    public int getItemCount() {
        return mFilms.size();
    }

//    public PokemonHelper[] pokemons;
//    public PokemonViewHolder.OnPokemonListener mOnPokemonListener;
//
//
//    public PokemonAdapter(PokemonHelper[] pokes, PokemonViewHolder.OnPokemonListener onPokemonListener){
//        super();
//        this.pokemons = pokes;
//        this.mOnPokemonListener = onPokemonListener;
//    }
//    public TextView textView;
//    public ImageView imageView;
//    @NonNull
//    @Override
//    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v =  LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.pokemon_item, parent, false);
//        PokemonViewHolder vh = new PokemonViewHolder(v,mOnPokemonListener);
//        return vh;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
//        holder.pokeName.setText(pokemons[position].name);
//        holder.pokeImage.setImageResource(pokemons[position].image);
//    }
//
//    @Override
//    public int getItemCount() {
//        return this.pokemons.length;
//    }
//
//
//    public PokemonHelper getItem(Integer position){
//        return this.pokemons[position];
//    }


}