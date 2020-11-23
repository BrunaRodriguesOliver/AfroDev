package com.example.pokedexapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexapp.API.ApiClient
import com.example.pokedexapp.Adapter.PokemonAdapter
import com.example.pokedexapp.Model.Pokemon
import com.example.pokedexapp.Model.PokemonResponse
import com.example.pokedexapp.Utils.Util.hideProgressBar
import com.example.pokedexapp.Utils.Util.isInternetAviable
import com.example.pokedexapp.Utils.Util.showProgressBar
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class MainActivity : AppCompatActivity() {

    private var adapter : PokemonAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        if (isInternetAviable()) {
            getPokeData()
        }


    }
  private fun getPokeData(){
      
      showProgressBar()
      
      ApiClient.apiService.getPokemon().enqueue(object :   retrofit2.Callback<PokemonResponse> {
          override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
              hideProgressBar()
              Log.e("Erro", t.localizedMessage)
          }

          override fun onResponse(call: Call<PokemonResponse>,
                                  response: Response<PokemonResponse>) {
              hideProgressBar()
              response.body()?.let{
                  setList(it.results)
              }
          }
      })
  }
    private fun setList(lista : List<Pokemon>){
         val recyclerView = findViewById<RecyclerView>(R.id.rvListaPokemon)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = PokemonAdapter(
                this,
                lista
        )
        recyclerView.adapter = adapter

    }
}






