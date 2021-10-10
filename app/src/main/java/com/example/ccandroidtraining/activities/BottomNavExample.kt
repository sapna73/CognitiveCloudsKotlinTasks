package com.example.ccandroidtraining.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ccandroidtraining.R
import com.example.ccandroidtraining.fragments.FirstFragment
import com.example.ccandroidtraining.fragments.SecondFragment
import com.example.ccandroidtraining.fragments.ThirdFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavExample : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bottom_nav_example)

        val navController = findNavController(R.id.nav_host_fragment_activity_bottom_navigation1)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigateBottomView)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.navigation_home->{
                    replaceFragment(FirstFragment())
                    Log.d("TAG", "First fragment.........")
                    true

                }
                R.id.navigation_dashboard->{
                    replaceFragment(SecondFragment())
                    Log.d("TAG", "second fragment.........")
                    true

                }
                R.id.navigation_notifications->{
                    replaceFragment(ThirdFragment())
                    Log.d("TAG", "third... fragment.........")
                    true

                }
            }
            false
        }
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
            R.id.action_view_slider->{
                intent = Intent(this, ViewPagerSlider::class.java)
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