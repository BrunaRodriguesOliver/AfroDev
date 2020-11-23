package com.example.pokedexapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedexapp.Model.Pokemon
import com.example.pokedexapp.R
import com.example.pokedexapp.Utils.PokeUtils
import kotlinx.android.synthetic.main.activity_pokemon_item.view.*
import java.sql.Types


class PokemonAdapter(private val context: Context, private var list: List<Pokemon>)
    :RecyclerView.Adapter<PokemonAdapter.PokeViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonAdapter.PokeViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.activity_pokemon_item, parent, false)

        return PokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonAdapter.PokeViewHolder, position: Int) {
        val pokemon = list.get(position)

        val nome = PokeUtils.capitalize(pokemon.name)
        holder.name?.text = nome



        //pega apenas os números de uma string
        var getIdFromUrl = pokemon.url.filter { it.isDigit() }

        //remove o primeiro caracter
        var removerFirstNumber = getIdFromUrl.drop(1)

        //pega Id do Pekemon
        var getId = removerFirstNumber.toInt()
        var idPokemon = PokeUtils.idMask(getId)
        holder.id?.text = idPokemon

      Glide.with(holder.imagem?.getContext())
           .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${removerFirstNumber}.png")
          .into(holder.imagem)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class PokeViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val imagem: ImageView
        var name: TextView? = null
        var id : TextView? = null
        var tipoPokemon : ImageView

        init {
            name = view.findViewById(R.id.nomePokemon)
            imagem = view.findViewById(R.id.img_padrao)
            id = view.findViewById(R.id.idPokemon)
            tipoPokemon = view.findViewById(R.id.tipo)
        }
    }
}