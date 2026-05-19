package com.example.fjcafestudyhub

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class menu : AppCompatActivity() {

    private val drinksList = listOf(
        Product("Caramel Latte",    "₱120.00", R.drawable.caramel_latte, "Drinks",
            "A rich and creamy latte with a smooth caramel drizzle."),
        Product("Espresso",         "₱90.00",  R.drawable.caramel_latte, "Drinks",
            "A strong and bold shot of freshly brewed espresso."),
        Product("Americano",        "₱95.00",  R.drawable.caramel_latte, "Drinks",
            "Espresso diluted with hot water for a smooth, light coffee."),
        Product("Cappuccino",       "₱110.00", R.drawable.caramel_latte, "Drinks",
            "Espresso topped with steamed milk foam for a creamy finish."),
        Product("Matcha Latte",     "₱130.00", R.drawable.caramel_latte, "Drinks",
            "A smooth blend of matcha green tea and steamed milk."),
        Product("Chamomile Tea",    "₱80.00",  R.drawable.caramel_latte, "Drinks",
            "A calming herbal tea perfect for relaxing study sessions.")
    )

    private val pastryList = listOf(
        Product("Croissant",        "₱75.00",  R.drawable.caramel_latte, "Pastry",
            "A buttery, flaky pastry baked to golden perfection."),
        Product("Blueberry Muffin", "₱70.00",  R.drawable.caramel_latte, "Pastry",
            "A soft muffin loaded with fresh blueberries."),
        Product("Chocolate Muffin", "₱70.00",  R.drawable.caramel_latte, "Pastry",
            "A rich muffin packed with chocolate chips."),
        Product("Scone",            "₱65.00",  R.drawable.caramel_latte, "Pastry",
            "A classic scone served with butter and jam."),
        Product("Oatmeal Cookie",   "₱50.00",  R.drawable.caramel_latte, "Pastry",
            "A chewy oatmeal cookie with a hint of cinnamon."),
        Product("Cheesecake Slice", "₱95.00",  R.drawable.caramel_latte, "Pastry",
            "A creamy slice of classic New York cheesecake.")
    )

    private val allList get() = drinksList + pastryList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val rvMenu = findViewById<RecyclerView>(R.id.rvMenu)
        val txtSectionLabel = findViewById<TextView>(R.id.txtSectionLabel)
        val tabCoffee = findViewById<TextView>(R.id.tabCoffee)
        val tabPastry = findViewById<TextView>(R.id.tabPastry)
        val tabHub = findViewById<TextView>(R.id.tabHub)
        val tabAll = findViewById<TextView>(R.id.tabAll)

        rvMenu.layoutManager = GridLayoutManager(this, 2)

        //deef
        loadProducts(rvMenu, txtSectionLabel, drinksList, "Drinks")
        setActiveTab(tabCoffee, listOf(tabPastry, tabHub, tabAll))

        //motingog is pisliton
        tabCoffee.setOnClickListener {
            loadProducts(rvMenu, txtSectionLabel, drinksList, "Drinks")
            setActiveTab(tabCoffee, listOf(tabPastry, tabHub, tabAll))
        }
        tabPastry.setOnClickListener {
            loadProducts(rvMenu, txtSectionLabel, pastryList, "Pastry")
            setActiveTab(tabPastry, listOf(tabCoffee, tabHub, tabAll))
        }
        tabHub.setOnClickListener {
            loadProducts(rvMenu, txtSectionLabel, pastryList, "Hub Specials")
            setActiveTab(tabHub, listOf(tabCoffee, tabPastry, tabAll))
        }
        tabAll.setOnClickListener {
            loadProducts(rvMenu, txtSectionLabel, allList, "All Items")
            setActiveTab(tabAll, listOf(tabCoffee, tabPastry, tabHub))
        }

        // cart button
        findViewById<ImageButton>(R.id.btnCart).setOnClickListener {
            startActivity(Intent(this, cart::class.java))
        }
        // Back button
        findViewById<ImageButton>(R.id.btnBack).setOnClickListener {
            finish()
        }

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
            //if pisliton ang katong product is ma abot sa productdetails na frame, any part within sa parameter
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

    private fun setActiveTab(active: TextView, inactive: List<TextView>) {
        active.setBackgroundColor(0xFF4E342E.toInt())
        active.setTextColor(0xFFFFFFFF.toInt())
        inactive.forEach {
            it.setBackgroundColor(0xFFF5E6D3.toInt())
            it.setTextColor(0xFF4E342E.toInt())
        }
    }

    private fun setupBottomNav() {
        findViewById<ImageButton>(R.id.navCart).setOnClickListener {
            startActivity(Intent(this,  cart::class.java))
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