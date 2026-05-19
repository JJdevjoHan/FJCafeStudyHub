package com.example.fjcafestudyhub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class modeoforder : AppCompatActivity() {

    private var selectedMode: String = "Pre-order"
    private var selectedSubMode: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modeoforder)

        val optionInStore  = findViewById<LinearLayout>(R.id.optionInStore)
        val optionPreOrder = findViewById<LinearLayout>(R.id.optionPreOrder)
        val optionPickSchedule = findViewById<LinearLayout>(R.id.optionPickSchedule)
        val optionPickup  = findViewById<LinearLayout>(R.id.optionPickup)
        val optionDelivery = findViewById<LinearLayout>(R.id.optionDelivery)

        val chkInStore = findViewById<CheckBox>(R.id.chkInStore)
        val chkPreOrder = findViewById<CheckBox>(R.id.chkPreOrder)
        val chkPickSchedule = findViewById<CheckBox>(R.id.chkPickSchedule)
        val chkPickup = findViewById<CheckBox>(R.id.chkPickup)
        val chkDelivery = findViewById<CheckBox>(R.id.chkDelivery)

        val btnClear = findViewById<TextView>(R.id.btnClear)

        // Pre-order is selected by default
        chkPreOrder.isChecked = true

        fun clearAll() {
            chkInStore.isChecked = false
            chkPreOrder.isChecked = false
            chkPickSchedule.isChecked = false
            chkPickup.isChecked = false
            chkDelivery.isChecked = false
        }

        optionInStore.setOnClickListener {
            clearAll()
            chkInStore.isChecked = true
            selectedMode = "In-store"
            selectedSubMode = ""
        }

        optionPreOrder.setOnClickListener {
            clearAll()
            chkPreOrder.isChecked = true
            selectedMode = "Pre-order"
            selectedSubMode = ""
        }

        optionPickSchedule.setOnClickListener {
            clearAll()
            chkPreOrder.isChecked = true
            chkPickSchedule.isChecked = true
            selectedMode = "Pre-order"
            selectedSubMode = "Pick-Schedule"
        }

        optionPickup.setOnClickListener {
            clearAll()
            chkPreOrder.isChecked = true
            chkPickup.isChecked = true
            selectedMode = "Pre-order"
            selectedSubMode = "Pickup"
        }

        optionDelivery.setOnClickListener {
            clearAll()
            chkDelivery.isChecked = true
            selectedMode = "Delivery"
            selectedSubMode = ""
        }

        //selectedmode
        findViewById<TextView>(R.id.btnNext).setOnClickListener {
            val intent = Intent(this, cart::class.java).apply {
                putExtra("orderMode", selectedMode)
                putExtra("orderSubMode", selectedSubMode)
            }
            startActivity(intent)
        }

        // Top bar
        findViewById<ImageButton>(R.id.btnBack).setOnClickListener { finish() }
        findViewById<ImageButton>(R.id.btnClose).setOnClickListener {
            startActivity(Intent(this, homescreen::class.java))
            finishAffinity()
        }

        //nextbutton
        findViewById<Button>(R.id.btnNext).setOnClickListener {
            startActivity(Intent(this, cart::class.java))
        }


        btnClear.setOnClickListener {
            chkInStore.isChecked = false
            chkPreOrder.isChecked = false
            chkPickSchedule.isChecked = false
            chkPickup.isChecked = false
            chkDelivery.isChecked = false
        }

        // Bottom nav
        setupBottomNav()
    }

    private fun setupBottomNav() {
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