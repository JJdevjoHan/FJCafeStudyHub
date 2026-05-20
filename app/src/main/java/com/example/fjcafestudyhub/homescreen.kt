package com.example.fjcafestudyhub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class homescreen : AppCompatActivity() {

    private val drinksList = listOf(
        Product("Espresso",         "₱90.00",  R.drawable.caramel_latte, "Popular Drink",
            "A strong and bold shot of freshly brewed espresso."),
        Product("Matcha Latte",     "₱130.00", R.drawable.caramel_latte, "Most Picked Drink",
            "A smooth blend of matcha green tea and steamed milk."),
        Product("Chamomile Tea",    "₱80.00",  R.drawable.caramel_latte, "All Time Favorite Drink",
            "A calming herbal tea perfect for relaxing study sessions.")
    )

    private val pastryList = listOf(
        Product("Croissant",        "₱75.00",  R.drawable.caramel_latte, "Popular Pastry",
            "A buttery, flaky pastry baked to golden perfection."),
        Product("Chocolate Muffin", "₱70.00",  R.drawable.caramel_latte, "Popular Pastry",
            "A rich muffin packed with chocolate chips."),
        Product("Scone",            "₱65.00",  R.drawable.caramel_latte, "Most Picked Pastry",
            "A classic scone served with butter and jam."),
        Product("Cheesecake Slice", "₱95.00",  R.drawable.caramel_latte, "All Time Favorite Pastry",
            "A creamy slice of classic New York cheesecake.")
    )

    private val allList get() = drinksList + pastryList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)

        val rvHome = findViewById<RecyclerView>(R.id.rvHome)
        val txtSectionLabel = findViewById<TextView>(R.id.txtSectionLabel)
        val chipCoffee = findViewById<TextView>(R.id.chipCoffee)
        val chipPastry = findViewById<TextView>(R.id.chipPastry)
        val chipHub = findViewById<TextView>(R.id.chipHub)

        rvHome.layoutManager = GridLayoutManager(this, 2)

        loadProducts(rvHome, txtSectionLabel, drinksList, "Highlights of the day!")
        setActiveChip(chipCoffee, listOf(chipPastry, chipHub))

        chipCoffee.setOnClickListener {
            loadProducts(rvHome, txtSectionLabel, drinksList, "Popular Drinks ")
            setActiveChip(chipCoffee, listOf(chipPastry, chipHub))
        }
        chipPastry.setOnClickListener {
            loadProducts(rvHome, txtSectionLabel, pastryList, "Recommended Pastry")
            setActiveChip(chipPastry, listOf(chipCoffee, chipHub))
        }

        findViewById<TextView>(R.id.chipHub).setOnClickListener {
            startActivity(Intent(this, hubmenu::class.java))
        }

        //makita tanan se all
        findViewById<TextView>(R.id.txtSeeAll).setOnClickListener {
            startActivity(Intent(this, menu::class.java))
        }

        findViewById<ImageButton>(R.id.btnMenu).setOnClickListener {
            startActivity(Intent(this, menu::class.java))
        }

        //account
        findViewById<ImageButton>(R.id.btnProfile).setOnClickListener {
            startActivity(Intent(this, account::class.java))
        }

        //nav
        setupBottomNav()
    }

    private fun loadProducts(
        rv: RecyclerView,
        label: TextView,
        list: List<Product>,
        title: String
    ) {
        label.text = title
        rv.adapter = MenuAdapter(list) { product ->
            val intent = Intent(this, productdetails::class.java).apply {
                putExtra("name",        product.name)
                putExtra("price",       product.price)
                putExtra("description", product.description)
                putExtra("image",       product.imageRes)
                putExtra("category",    product.category)
            }
            startActivity(intent)
        }
    }

    private fun setActiveChip(active: TextView, inactive: List<TextView>) {
        active.setBackgroundColor(0xFF3E2723.toInt())
        active.setTextColor(0xFFFFFFFF.toInt())
        inactive.forEach {
            it.setBackgroundColor(0xFFFFF8F0.toInt())
            it.setTextColor(0xFF3E2723.toInt())
        }
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