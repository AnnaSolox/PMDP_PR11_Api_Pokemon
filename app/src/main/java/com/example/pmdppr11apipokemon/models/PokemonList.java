package com.example.pmdppr11apipokemon.models;

import java.util.ArrayList;

public class PokemonList {
    private ArrayList<Pokemon> results;
    public ArrayList<Pokemon> getResults(){
        return results;
    }

    public void setResults(ArrayList<Pokemon> results){
        this.results = results;
    }
}
