package com.example.pmdppr11apipokemon.poqueapi;

import com.example.pmdppr11apipokemon.models.Pokemon;
import com.example.pmdppr11apipokemon.models.PokemonList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeApiService {
    String BASE_URL = "https://pokeapi.co/api/v2/";

    //endpoint para único pokemon por ID
    @GET("pokemon/{id}")
    Call<Pokemon> getPokemonById(@Path("id") String id);

    //endpoint para listado de pokemons
    @GET("pokemon")
    Call<PokemonList> getPokemonList(@Query("limit") int limit, @Query("offset") int offset);
}
