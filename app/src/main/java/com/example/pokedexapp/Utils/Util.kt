@file:Suppress("DEPRECATION", "UNREACHABLE_CODE")

package com.example.pokedexapp.Utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.pokedexapp.R
import org.jetbrains.anko.toast

object Util {

    private var progressBar : ProgressBar? = null

    @SuppressLint("ServiceCast")
    fun Context.isInternetAviable() : Boolean{
        try{
            val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            return if (netInfo != null && netInfo.isConnected) {
                true
            } else {
                showErrorToast("Internet not available. Please try again!!")
                false
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
        }

    private fun Context.showErrorToast(message : String) {
        try{
            val toast = Toast.makeText(this,"Erro na conexão", Toast.LENGTH_LONG).show()
        } catch (e: Exception){
            e.printStackTrace()
        }

    }

     fun Context.showProgressBar() {
        try {

            val layout = (this as? Activity)?.findViewById<View>(android.R.id.content)?.rootView as? ViewGroup
            progressBar = ProgressBar(this, null, R.attr.progressBarStyle)
            progressBar?.let { it1 ->
                it1.isIndeterminate = true

                val params = RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT
                )

                val rl = RelativeLayout(this)

                rl.gravity = Gravity.CENTER
                rl.addView(it1)

                layout?.addView(rl, params)

                it1.visibility = View.VISIBLE
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun hideProgressBar() {
        try {
            progressBar?.let {
                it.visibility = View.GONE
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
