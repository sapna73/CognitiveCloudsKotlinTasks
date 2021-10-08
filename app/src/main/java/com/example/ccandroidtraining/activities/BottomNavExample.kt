package com.example.ccandroidtraining.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.ccandroidtraining.R
import com.example.ccandroidtraining.fragments.FirstFragment

class BottomNavExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bottom_nav_example)
        replaceFragment(FirstFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.auth_navigation, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_settings ->{
                intent = Intent(this, TabActivity::class.java)
                startActivity(intent)
            }
            R.id.action_notification->{
                intent = Intent(this, UIWidgets::class.java)
                startActivity(intent)
            }
            R.id.action_nav_drawer->{
                intent = Intent(this, AuthNavigationActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
// Extension function to replace fragment
fun AppCompatActivity.replaceFragment(fragment: Fragment){
    val fragmentManager = supportFragmentManager
    val transaction = fragmentManager.beginTransaction()
    transaction.replace(R.id.containerBottom,fragment)
    transaction.addToBackStack(null)
    transaction.commit()
}