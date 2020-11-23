package com.example.pokedexapp.Model

data class PokemonResponse(
        val count: Int,
        val next: String,
        val previous: Any,
        val results: List<Pokemon>
)