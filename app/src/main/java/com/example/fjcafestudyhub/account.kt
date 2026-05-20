package com.example.fjcafestudyhub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class account : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        // Logout button
        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish()
        }

        findViewById<ImageButton>(R.id.btnBack).setOnClickListener {
            finish()
        }

    }
}