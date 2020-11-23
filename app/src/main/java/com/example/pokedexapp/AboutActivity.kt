package com.example.pokedexapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.hide()

        val txtAbout = findViewById<TextView>(R.id.txtAbout)

        txtAbout.text = "A Pokédex is an electronic device designed to catalogue and " +
                "provide information regarding the various species of Pokémon featured in " +
                "the Pokémon video game, anime and manga series."
    }
}