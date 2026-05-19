package com.example.fjcafestudyhub

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Locator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_locator)

        //nav
        findViewById<ImageButton>(R.id.navCart).setOnClickListener {
            startActivity(Intent(this, cart::class.java))
        }
        findViewById<ImageButton>(R.id.navLocator).setOnClickListener {
            startActivity(Intent(this, Locator::class.java))
        }
        findViewById<ImageButton>(R.id.navHome).setOnClickListener {
            startActivity(Intent(this, homescreen::class.java))
        }
        findViewById<ImageButton>(R.id.navRewards).setOnClickListener {
            startActivity(Intent(this, rewards::class.java))
        }
        findViewById<ImageButton>(R.id.navSettings).setOnClickListener {
            startActivity(Intent(this, settings::class.java))
        }

        // Back button
        findViewById<ImageButton>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}