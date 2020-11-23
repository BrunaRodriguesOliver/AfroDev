package com.example.pokedexapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        enviaDados()
    }

    fun enviaDados() {
        var btnEnvia = findViewById<Button>(R.id.buttonGo)
        var nome = findViewById<EditText>(R.id.edtRecebeNome)

        btnEnvia.setOnClickListener {

            val intent = Intent(this, LoadingActivity::class.java)
            val parans = Bundle()

            val nomeDigitado = nome.text.toString()
            parans.putString("edtName", nomeDigitado)
            intent.putExtras(parans)
            startActivity(intent)
        }
    }
}