package com.example.fjcafestudyhub

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.fjcafestudyhub.forgotpassword
import com.example.fjcafestudyhub.menu
import com.example.fjcafestudyhub.R

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //if pisliton ang sign-in na button mo redirect sa registration or creare account
        val txtGoToRegister = findViewById<TextView>(R.id.txtGoToRegister)
        txtGoToRegister.setOnClickListener {
            val intent = Intent(this, registration::class.java)
            startActivity(intent)
        }

        //if pisliton ang log in button then mo daretsu sa homescreen
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val intent = Intent(this, homescreen::class.java)
            startActivity(intent)
        }

        //if forgotpassword ky padong pd sa forgotpassword frame
        val txtForgotPassword = findViewById<TextView>(R.id.txtForgotPassword)
        txtForgotPassword.setOnClickListener {
            val intent = Intent(this, forgotpassword::class.java)
            startActivity(intent)
        }
    }
}