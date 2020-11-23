package com.example.pokedexapp.API

import com.example.pokedexapp.Model.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("pokemon")
    fun getPokemon() : Call<PokemonResponse>

    @GET("types")
    fun getTypePokemon() : Call<PokemonResponse>
}