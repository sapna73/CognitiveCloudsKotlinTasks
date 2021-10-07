package com.example.ccandroidtraining.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ccandroidtraining.R
import com.example.ccandroidtraining.model.ItemsModel

class RecyclerAdapter(private val mList: List<ItemsModel>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_list, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)
        holder.imageView.setOnClickListener(){
//            val position = holder.adapterPosition
//            val model = mList[position]
//            mOnProductClickListener.onDelete(model)
        }

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.text
    }

    fun deleteItem(position: Int){
//        mList.removeAt(position)
//        notifyDataSetChanged()
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}