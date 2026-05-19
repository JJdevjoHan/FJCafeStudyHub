package com.example.fjcafestudyhub

import androidx.appcompat.app.AppCompatActivity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.fjcafestudyhub.R
import com.example.fjcafestudyhub.login

class forgotpassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)

        val etResetEmail = findViewById<EditText>(R.id.etResetEmail)
        val btnSendReset = findViewById<Button>(R.id.btnSendReset)
        val txtGoToLogin = findViewById<TextView>(R.id.txtGoToLogin)

        btnSendReset.setOnClickListener {
            val email = etResetEmail.text.toString().trim()
            //check if empty
            if (email.isEmpty()) {
                etResetEmail.error = "Please enter your email"
                etResetEmail.requestFocus()
                return@setOnClickListener
            }

            //validation
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etResetEmail.error = "Please enter a valid email"
                etResetEmail.requestFocus()
                return@setOnClickListener
            }

            //successdialog
            AlertDialog.Builder(this)
                .setTitle("Reset Link Sent!")
                .setMessage("A password reset link has been sent to:\n\n$email\n\nPlease check your inbox.")
                .setPositiveButton("Back to Login") { _, _ ->
                    val intent = Intent(this, login::class.java)
                    startActivity(intent)
                    finish()
                }
                .setCancelable(false)
                .show()
        }

        //login text is for login balik
        txtGoToLogin.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish()
        }
    }
}