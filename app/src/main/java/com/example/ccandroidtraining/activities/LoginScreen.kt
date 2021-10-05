package com.example.ccandroidtraining.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.ccandroidtraining.R

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        var buttonLogin = findViewById<Button>(R.id.btnLogin)
        var editTextName = findViewById<EditText>(R.id.et_user_name)
        var editTextPassword = findViewById<EditText>(R.id.et_password)
        var tvForget = findViewById<TextView>(R.id.tvForgetPassword)
        var tvSignUp = findViewById<TextView>(R.id.tvSignup)
        var linearLayout = findViewById<LinearLayout>(R.id.linearLogin)

        buttonLogin.setOnClickListener(){
            val userName = editTextName.text;
            val password = editTextPassword.text;
            Toast.makeText(this@LoginScreen, userName, Toast.LENGTH_LONG).show()
            
            intent = Intent(this, UIWidgets::class.java)
            startActivity(intent)
        }

        editTextName.setOnClickListener(){
            intent = Intent(this, UIWidgets::class.java)
            startActivity(intent)
        }

        editTextPassword.setOnClickListener(){
            intent = Intent(this, UIWidgets::class.java)
            startActivity(intent)
        }

        tvForget.setOnClickListener(){
            intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }

        tvSignUp.setOnClickListener(){
            intent = Intent(this, SignInScreen::class.java)
            startActivity(intent)
        }

        linearLayout.setOnClickListener(){
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}