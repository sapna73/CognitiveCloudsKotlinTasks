package com.example.ccandroidtraining.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.ccandroidtraining.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView = findViewById<TextView>(R.id.here)

        textView.setOnClickListener(){
            intent = Intent(this, UIWidgets::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        //It will show toast message on screen
        //onStart will be invoked
        val toast = Toast.makeText(applicationContext, "onStart called", Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        //onRestart is invoked
        val toast = Toast.makeText(applicationContext, "onRestart called", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        //onResume is invoked
        val toast = Toast.makeText(applicationContext, "onResume is called..", Toast.LENGTH_LONG).show()
    }

    override fun onPause(){
        super.onPause()
        //onPause is invoked
        val toast = Toast.makeText(applicationContext, "onPause is called..", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        //onStop is invoked
        val toast = Toast.makeText(applicationContext, "onStop Called", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        //onDestroy is invoked
        val toast = Toast.makeText(applicationContext, "onDestroy Called", Toast.LENGTH_LONG).show()
    }
}