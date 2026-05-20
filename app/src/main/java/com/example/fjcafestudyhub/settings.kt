package com.example.fjcafestudyhub

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        findViewById<TextView>(R.id.btnAccount).setOnClickListener {
            startActivity(Intent(this, account::class.java))
        }

        findViewById<TextView>(R.id.btnAbout).setOnClickListener {
            startActivity(Intent(this, about::class.java))
        }


        NavButton()
    }

    private fun NavButton(){
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
    }
}