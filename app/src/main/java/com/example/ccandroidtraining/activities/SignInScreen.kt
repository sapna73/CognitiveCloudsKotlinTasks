package com.example.ccandroidtraining.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.ccandroidtraining.R

class SignInScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_screen)

        var tvLoginInSign = findViewById<TextView>(R.id.tvLogin)

        tvLoginInSign.setOnClickListener(){
            intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
        }
    }
}