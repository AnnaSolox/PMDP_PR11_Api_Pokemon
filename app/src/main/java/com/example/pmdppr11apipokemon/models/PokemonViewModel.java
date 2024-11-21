package com.example.pmdppr11apipokemon.models;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.pmdppr11apipokemon.R;
import com.example.pmdppr11apipokemon.poqueapi.PokeApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonViewModel extends AndroidViewModel {
    private Retrofit retrofit;
    private PokeApiService pokeApiService;

    public PokemonViewModel(@NonNull Application application){
        super(application);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pokeApiService = retrofit.create(PokeApiService.class);
    }

    public void getPokemonList(int offset){
        Call<PokemonList> call = pokeApiService.getPokemonList(20, offset);
        call.enqueue(new Callback<PokemonList>() {
            @Override
            public void onResponse(Call<PokemonList> call, Response<PokemonList> response) {
                if (response.body() != null) {
                    PokemonList pokemonList = response.body();
                    for (Pokemon pokemon : pokemonList.getResults()) {
                        Log.d("POKEMON NAME", pokemon.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<PokemonList> call, Throwable t) {
                Toast.makeText(getApplication(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getPokemonById() {
        Call<Pokemon> call = pokeApiService.getPokemonById(Integer.toString((int) (Math.random() * 807 + 1)));
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (response.body() != null) {
                    Pokemon foundPoke = response.body();
                    Log.d("POKEMON NAME", foundPoke.getName());
                    Log.d("POKEMON HEIGHT", foundPoke.getHeight());
                    Log.d("POKEMON WEIGHT", foundPoke.getWeight());
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e("API ERROR", t.getMessage(), t);  // Imprime más detalles sobre el error
                Toast.makeText(getApplication(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
