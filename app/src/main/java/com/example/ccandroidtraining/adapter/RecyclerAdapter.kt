package com.example.ccandroidtraining.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ccandroidtraining.R
import com.example.ccandroidtraining.model.ItemsModel

class RecyclerAdapter (private val moviesList: List<ItemsModel>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById<TextView>(R.id.title)
        var year: TextView = view.findViewById<TextView>(R.id.year1)
        var genre: TextView = view.findViewById<TextView>(R.id.genre1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_list, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val Movies = moviesList[position]
        holder.title.text = Movies.title
        holder.genre.text = Movies.genre
        holder.year.text = Movies.year
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}