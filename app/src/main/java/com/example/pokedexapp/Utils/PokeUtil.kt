package com.example.pokedexapp.Utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.example.pokedexapp.R
import java.util.*

object PokeUtils {

    fun capitalize(string: String) : String{
        val result = string.substring(0, 1).toUpperCase(Locale.ROOT) + (string.substring(1));
        return result
    }

    fun getImageByString(c: Context, imageName: String?): Drawable? {
        return ContextCompat.getDrawable(
            c,
            c.resources.getIdentifier(imageName, "drawable", c.packageName)
        )
    }

    fun idMask(id: Int): String {
        id.let {
            return when (id) {
                in 1..9 -> "#00${id}"
                in 10..99 -> "#0${id}"
                else -> "#$id"
            }
        }
    }


    fun getColorForType(type: String) : Int{
        val returnId : Int

        when(type){
            "bug" -> returnId = R.color.bug
            "dark" -> returnId = R.color.dark
            "dragon" -> returnId = R.color.dragon
            "electric" -> returnId = R.color.electric
            "fairy" -> returnId = R.color.fairy
            "fighting" -> returnId = R.color.fighting
            "fire" -> returnId = R.color.fire
            "steer" -> returnId = R.color.iron
            "flying" -> returnId = R.color.flying
            "ghost" -> returnId = R.color.ghost
            "grass" -> returnId = R.color.grass
            "ground" -> returnId = R.color.ground
            "ice" -> returnId = R.color.ice
            "iron" -> returnId = R.color.iron
            "normal" -> returnId = R.color.normal
            "poison" -> returnId = R.color.poison
            "psychic" -> returnId = R.color.psychic
            "rock" -> returnId = R.color.rock
            "water" -> returnId = R.color.water
            else -> returnId = R.color.normal
        }

        return returnId
    }

    fun getThemeForType(type: String) : Int{
        val returnId : Int

        when(type){
            "bug" -> returnId = R.style.bug
            "dark" -> returnId = R.style.dark
            "dragon" -> returnId = R.style.dragon
            "electric" -> returnId = R.style.electric
            "fairy" -> returnId = R.style.fairy
            "fighting" -> returnId = R.style.fighting
            "fire" -> returnId = R.style.fire
            "flying" -> returnId = R.style.flying
            "ghost" -> returnId = R.style.ghost
            "grass" -> returnId = R.style.grass
            "ground" -> returnId = R.style.ground
            "ice" -> returnId = R.style.ice
            "steel" -> returnId = R.style.steel
            "normal" -> returnId = R.style.normal
            "poison" -> returnId = R.style.poison
            "psychic" -> returnId = R.style.psychic
            "rock" -> returnId = R.style.rock
            "water" -> returnId = R.style.water
            else -> returnId = R.style.normal
        }

        return returnId
    }
}