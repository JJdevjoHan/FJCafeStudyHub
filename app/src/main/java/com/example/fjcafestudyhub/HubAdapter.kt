package com.example.fjcafestudyhub

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HubAdapter(
    private val rooms: List<Product>,
    private val onSeeMoreClick: (Product) -> Unit
) : RecyclerView.Adapter<HubAdapter.HubViewHolder>() {

    inner class HubViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgRoom)
        val name: TextView = view.findViewById(R.id.txtRoomName)
        val price: TextView = view.findViewById(R.id.txtRoomPrice)
        val btnBook: Button = view.findViewById(R.id.btnBook)
        val btnSeeMore: TextView = view.findViewById(R.id.btnSeeMore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HubViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_hub, parent, false)
        return HubViewHolder(view)
    }

    override fun onBindViewHolder(holder: HubViewHolder, position: Int) {
        val room = rooms[position]
        holder.img.setImageResource(room.imageRes)
        holder.name.text = room.name
        holder.price.text = room.price

        holder.btnBook.setOnClickListener {
            val intent = Intent(holder.itemView.context, booking::class.java).apply {
                putExtra("roomName", room.name)
                putExtra("price", room.price)
            }
            holder.itemView.context.startActivity(intent)
        }

        holder.btnSeeMore.setOnClickListener { onSeeMoreClick(room) }
    }

    override fun getItemCount() = rooms.size
}
