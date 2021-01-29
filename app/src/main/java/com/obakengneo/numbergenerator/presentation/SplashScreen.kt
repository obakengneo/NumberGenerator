package com.obakengneo.numbergenerator.presentation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.obakengneo.numbergenerator.R
import com.obakengneo.numbergenerator.util.Utility

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Utility().setTheme(this, this)
        setContentView(R.layout.activity_splashscreen)

        val handler = Handler()
        handler.postDelayed({

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 1000)
    }
}