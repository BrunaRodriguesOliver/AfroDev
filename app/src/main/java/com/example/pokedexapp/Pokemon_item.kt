package com.example.pokedexapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import com.example.pokedexapp.Utils.PokeUtils


class Pokemon_item : AppCompatActivity() {
    lateinit var viewPager: ViewPager

    private val baseURL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"
    private val pokemonIcon: ImageView by lazy { findViewById(R.id.img_padrao) }
    private val pokemonName: TextView by lazy { findViewById(R.id.nomePokemon) }
    private val pokemonId: TextView by lazy { findViewById(R.id.idPokemon) }
    private val view: ConstraintLayout by lazy { findViewById(R.id.pokemonView) }
    private val list: List<View> by lazy { listOf(pokemonIcon, pokemonName, pokemonId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
