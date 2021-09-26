package com.example.ccandroidtraining.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ccandroidtraining.R

class UIWidgets : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uiwidgets)

        var buttonShow = findViewById<Button>(R.id.showId)

        buttonShow.setOnClickListener(){
            intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
    }
}