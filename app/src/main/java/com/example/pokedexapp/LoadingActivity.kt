package com.example.pokedexapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        supportActionBar?.hide()

        val rcbNome = findViewById<TextView>(R.id.rcbName)
        val nomeRecebido = intent.getStringExtra("edtName")

        rcbNome.text = nomeRecebido
        changeToMain()

    }

    fun changeToMain () {
        val intentMain = Intent(this, MainActivity::class.java)
        GlobalScope.launch {
            delay(2500)
            intentMain.change()
        }
    }

    fun  Intent.change(){
        startActivity(this)
        finish()
    }
}