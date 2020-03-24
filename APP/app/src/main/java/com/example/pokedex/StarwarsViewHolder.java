package com.example.pokedex;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class StarwarsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView filmTitle;
    public TextView episode;
    public TextView director;
    public TextView producer;
    public TextView release;

    public StarwarsViewHolder(View itemView) {
        // Stores the itemView in a public final member variable that can be used
        // to access the context from any ViewHolder instance.
        super(itemView);

        filmTitle = (TextView) itemView.findViewById(R.id.filmTitle);
        episode = (TextView) itemView.findViewById(R.id.episode);
        director = (TextView) itemView.findViewById(R.id.director);
        producer = (TextView) itemView.findViewById(R.id.producer);
        release = (TextView) itemView.findViewById(R.id.release);

//        pokemonImage = (ImageView) itemView.findViewById(R.id.pokemonImage);
    }

    @Override
    public void onClick(View v) {

    }


//    public TextView pokeName;
//    public ImageView pokeImage;
//    OnPokemonListener onPokemonListener;
//    public PokemonViewHolder(@NonNull View itemView, OnPokemonListener onPokemonListener) {
//        super(itemView);
//        this.pokeName = itemView.findViewById(R.id.pokemonName);
//        this.pokeImage = itemView.findViewById(R.id.pokemonImage);
//        this.onPokemonListener = onPokemonListener;
//        itemView.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        onPokemonListener.onPokemonClick((getAdapterPosition()));
//    }
//
//    public interface OnPokemonListener{
//        void onPokemonClick(int position);
//    }

}