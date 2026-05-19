package com.example.fjcafestudyhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.fjcafestudyhub.R

class productdetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productdetails)

        //receivingcenter gikan sa menu
        val name = intent.getStringExtra("name") ?: "Product"
        val price = intent.getStringExtra("price") ?: "₱0.00"
        val category = intent.getStringExtra("category") ?: ""
        val description = intent.getStringExtra("description") ?: ""
        val imageRes = intent.getIntExtra("imageRes", R.drawable.caramel_latte)

        //then display after receive
        findViewById<TextView>(R.id.txtProductName).text = name
        findViewById<TextView>(R.id.txtProductPrice).text = price
        findViewById<TextView>(R.id.txtCategory).text = category
        findViewById<TextView>(R.id.txtDescription).text = description
        findViewById<ImageView>(R.id.imgProductDetail).setImageResource(imageRes)

        //quantityselector
        var quantity = 1
        val txtQuantity = findViewById<TextView>(R.id.txtQuantity)

        findViewById<Button>(R.id.btnIncrease).setOnClickListener {
            quantity++
            txtQuantity.text = quantity.toString()
        }

        findViewById<Button>(R.id.btnDecrease).setOnClickListener {
            if (quantity > 1) {
                quantity--
                txtQuantity.text = quantity.toString()
            }
        }

        // Back button
        findViewById<ImageButton>(R.id.btnBack).setOnClickListener {
            finish()
        }

        //addtocart button
        findViewById<Button>(R.id.btnAddToCart).setOnClickListener {
            startActivity(Intent(this, cart::class.java))
        }

        findViewById<Button>(R.id.btnBuy).setOnClickListener {
            startActivity(Intent(this, modeoforder::class.java))
        }
    }
}