package com.example.fjcafestudyhub

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splashscreen)
        //main ni sya, nag count syag 2 seconds para mo sulod dayon sa loginpage
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, login::class.java))
            finish()
        }, 2000)
    }
}