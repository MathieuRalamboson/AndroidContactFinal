package com;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.model.Pokemon;
import com.model.RestPokemonResponse;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private MainActivity activity;

    public MainController(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void onStart(){

        //Pour ceux qui veulent aller plus loin
        //Singleton
        //Pour ceux qui veulent aller encore plus loin
        // Injection de dépendances

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.coinlore.com/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestPokemonApi restPokemonApi = retrofit.create(RestPokemonApi.class);

        Call<RestPokemonResponse> call = restPokemonApi.getListPokemon();
        call.enqueue(new Callback<RestPokemonResponse>() {
            @Override
            public void onResponse(Call<RestPokemonResponse> call,
                    Response<RestPokemonResponse> response) {
                Log.d("ERROR", "Api Response");
                RestPokemonResponse restPokemonResponse = response.body();
                List<Pokemon> listPokemon = restPokemonResponse.getResults();
                activity.showList(listPokemon);
            }

            @Override
            public void onFailure(Call<RestPokemonResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });
    }
}
