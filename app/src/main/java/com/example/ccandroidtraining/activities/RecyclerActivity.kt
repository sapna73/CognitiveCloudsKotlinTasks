package com.example.ccandroidtraining.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ccandroidtraining.R
import com.example.ccandroidtraining.adapter.RecyclerAdapter
import com.example.ccandroidtraining.model.ItemsModel

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..40) {
            data.add(ItemsModel(R.drawable.ic_baseline_delete_24, "Recycler Items " + i))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = RecyclerAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }

}