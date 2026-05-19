package com.example.fjcafestudyhub

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class confirmation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val message = intent.getStringExtra("message") ?: "Order Confirmed!"
        val details = intent.getStringExtra("details") ?: ""

        val confirmationMessage = findViewById<TextView>(R.id.confirmationMessage)
        val confirmationDetails = findViewById<TextView>(R.id.confirmationDetails)

        confirmationMessage.text = message
        confirmationDetails.text = details

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, homescreen::class.java))
            finish()
        }, 5000)
    }
}
