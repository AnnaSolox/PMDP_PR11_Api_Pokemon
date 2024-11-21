package com.example.pmdppr11apipokemon;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.pmdppr11apipokemon.models.Pokemon;
import com.example.pmdppr11apipokemon.models.PokemonList;
import com.example.pmdppr11apipokemon.models.PokemonViewModel;
import com.example.pmdppr11apipokemon.poqueapi.PokeApiService;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        PokemonViewModel pokemonViewModel = new ViewModelProvider(this).get(PokemonViewModel.class);
        //Mostrar un pokemon aleatorio por consola
        //pokemonViewModel.getPokemonById();

        //Mostrar todos los pokemons saltándonos los primeros 500
        pokemonViewModel.getPokemonList(500);
    }
}