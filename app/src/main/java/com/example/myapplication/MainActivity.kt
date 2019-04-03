package com.example.myapplication

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val animationHandler = Handler()
    private lateinit var animationRunnable: Runnable
    private var textViewHop: TextView? = null

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        animationRunnable = Runnable { animationFunction() }
        animationHandler.post(animationRunnable)
        textViewHop = findViewById(R.id.textViewHop)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    private fun animationFunction() {
        val animation = textViewHop?.animate()?.translationYBy(-40f)?.setDuration(200)
        animation?.withEndAction {
            textViewHop?.animate()?.translationYBy(40f)?.duration = 200
        }
        animationHandler.postDelayed(animationRunnable, 1000)
    }
}
