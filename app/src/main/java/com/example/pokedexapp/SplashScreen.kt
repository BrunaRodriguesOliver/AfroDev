package com.example.pokedexapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()

        changeToLogin()
    }
    fun changeToLogin () {
        val intent = Intent(this, LoginActivity::class.java )

//        Handler().postDelayed({
//            intent.change()
//        }, 3000)

        GlobalScope.launch {
            delay(3000)
            intent.change()
        }
//
    }
    fun Intent.change(){
        startActivity(this)
        finish()
    }
}
