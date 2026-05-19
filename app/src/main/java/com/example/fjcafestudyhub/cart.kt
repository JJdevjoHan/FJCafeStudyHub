package com.example.fjcafestudyhub

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class cart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val reviewItems = findViewById<TextView>(R.id.reviewItems)
        val reviewTotal = findViewById<TextView>(R.id.reviewTotal)

        val items = listOf("Caramel Latte x1", "Espresso x2")
        val itemsSummary = items.joinToString("\n• ", prefix = "• ")
        reviewItems.text = itemsSummary

        val totalAmount = 150.00
        reviewTotal.text = "Total: ₱%.2f".format(totalAmount)

        val btnReview = findViewById<TextView>(R.id.btnReview)
        val reviewSection = findViewById<LinearLayout>(R.id.reviewSection)

        btnReview.setOnClickListener {
            reviewSection.visibility = if (reviewSection.visibility == View.VISIBLE) {
                View.GONE
            } else {
                View.VISIBLE
            }
        }

        findViewById<ImageButton>(R.id.btnBack).setOnClickListener {
            finish() // goes back to previous screen
        }
        /*
        findViewById<TextView>(R.id.btnOrder).setOnClickListener {
            startActivity(Intent(this, modeoforder::class.java))
        }
        findViewById<TextView>(R.id.btnReview).setOnClickListener {
            // show review dialog or go to review screen
        }

         */

        NavButtons()
    }

    private fun NavButtons(){

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