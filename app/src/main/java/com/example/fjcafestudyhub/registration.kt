package com.example.fjcafestudyhub

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        //login na textview then mo adto sa login
        val txtGoToLogin = findViewById<TextView>(R.id.txtGoToLogin)
        txtGoToLogin.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        //imbis mo sulod dayon kung create account, mo agi sya balik sa login
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish() // close Register so back button won't return here
        }
    }
}