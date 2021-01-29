package com.obakengneo.numbergenerator.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.obakengneo.numbergenerator.R
import com.obakengneo.numbergenerator.model.Card

class CardsAdapter(var context: Context, var list: ArrayList<Card>) :
    RecyclerView.Adapter<CardsAdapter.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsAdapter.ItemHolder {
        val itemHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.cards_gridlayout, parent, false)

        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: CardsAdapter.ItemHolder, position: Int) {
        val card: Card = list[position]

        holder.icons.setImageResource(card.icons!!)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var icons: ImageView = itemView.findViewById<ImageView>(R.id.imgCard)
    }
}