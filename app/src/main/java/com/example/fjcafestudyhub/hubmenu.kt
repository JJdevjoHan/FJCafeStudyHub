
package com.example.fjcafestudyhub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class hubmenu : AppCompatActivity() {

    private val roomList = listOf(
        Product("Quiet Study Room", "₱50/hr", R.drawable.study_room, "Study Hub",
            "A peaceful room designed for focused individual study."),
        Product("Group Study Room", "₱120/hr", R.drawable.group_room, "Study Hub",
            "Spacious room for collaborative group sessions."),
        Product("Presentation Hub", "₱200/hr", R.drawable.presentation_room, "Study Hub",
            "Equipped with projector and whiteboard for presentations."),
        Product("Cozy Corner", "₱80/hr", R.drawable.corner_room, "Study Hub",
            "Comfortable space with couches for relaxed studying.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hubmenu)

        val rvHub = findViewById<RecyclerView>(R.id.rvHub)
        val txtSectionLabel = findViewById<TextView>(R.id.txtSectionLabel)

        rvHub.layoutManager = GridLayoutManager(this, 2)
        txtSectionLabel.text = "Available Study Hubs"

        rvHub.adapter = HubAdapter(roomList) { product ->
            val intent = Intent(this, productdetails::class.java).apply {
                putExtra("name", product.name)
                putExtra("price", product.price)
                putExtra("description", product.description)
                putExtra("image", product.imageRes)
                putExtra("category", product.category)
            }
            startActivity(intent)
            openBooking()
        }

    }

    private fun openBooking()
    {
        findViewById<Button>(R.id.btnBook).setOnClickListener {
            startActivity(Intent(this, booking::class.java))
        }
    }
}
