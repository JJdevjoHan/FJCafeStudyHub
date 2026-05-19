package com.example.fjcafestudyhub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(
    private val products: List<Product>,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<MenuAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView   = view.findViewById(R.id.imgProduct)
        val name: TextView   = view.findViewById(R.id.txtProductName)
        val price: TextView  = view.findViewById(R.id.txtProductPrice)
        val btn: Button      = view.findViewById(R.id.btnAddToCart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_itemmenucard, parent, false)
        return ProductViewHolder(view)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.img.setImageResource(product.imageRes)
        holder.name.text  = product.name
        holder.price.text = product.price

        //adto sa detail screen
        holder.itemView.setOnClickListener { onItemClick(product) }

        //para sa addtocart
        holder.btn.setOnClickListener { onItemClick(product) }
    }

    override fun getItemCount() = products.size
}