package com.example.ccandroidtraining.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.ccandroidtraining.R

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        var buttonLogin = findViewById<TextView>(R.id.btnLogin)
        buttonLogin.setOnClickListener(){
            intent = Intent(this, UIWidgets::class.java)
            startActivity(intent)
        }
    }
}