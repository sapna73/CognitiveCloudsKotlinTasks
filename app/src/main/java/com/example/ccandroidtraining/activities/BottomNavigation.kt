package com.example.ccandroidtraining.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ccandroidtraining.R
import com.example.ccandroidtraining.`interface`.PassData
import com.example.ccandroidtraining.activities.ui.dashboard.DashboardFragment
import com.example.ccandroidtraining.activities.ui.home.HomeFragment
import com.example.ccandroidtraining.activities.ui.notifications.NotificationsFragment
//import com.example.ccandroidtraining.activities.databinding.ActivityBottomNavigationBinding
import com.example.ccandroidtraining.databinding.ActivityBottomNavigationBinding

class BottomNavigation : AppCompatActivity() {

    val homeFragment = HomeFragment()//Fragment 1
    val searchFragment = DashboardFragment() //Fragment 2
    val ordersFragment = NotificationsFragment() //Fragment 3

    public lateinit var binding: ActivityBottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_bottom_navigation)

        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_bottom_navigation)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        replaceFragment(HomeFragment())
    }

    // Extension function to replace fragment
    fun AppCompatActivity.replaceFragment(fragment:Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
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
        }
        return super.onOptionsItemSelected(item)
    }

}
