package com.example.ccandroidtraining.activities.ui.home

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ccandroidtraining.R
import com.example.ccandroidtraining.`interface`.PassData
import com.example.ccandroidtraining.activities.BottomNavigation
import com.example.ccandroidtraining.activities.UIWidgets
import com.example.ccandroidtraining.activities.ui.dashboard.DashboardFragment
import com.example.ccandroidtraining.activities.ui.notifications.NotificationsFragment
//import com.example.ccandroidtraining.activities.R
//import com.example.ccandroidtraining.activities.databinding.FragmentHomeBinding
import com.example.ccandroidtraining.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), PassData {
//    private lateinit var communicator: Communicator

    val searchFragment = DashboardFragment()
    val ordersFragment = NotificationsFragment()
    val editTextInput: String = ""
    val bottomNav = BottomNavigation()

    private lateinit var passData: PassData
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val buttonSend: Button = binding.btnSendData
        val editText: EditText = binding.etUserName
//        passData = activity as PassData
//        buttonSend.setOnClickListener{
//            passData.passData(editText.text.toString())
//        }
        val root: View = binding.root
        val root1: View = binding.etUserName

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        // Replace fragment
        buttonSend.setOnClickListener {
            // Pass data to fragment
            val bundle = Bundle()
            bundle.putString("messageInput", editTextInput)
            searchFragment.arguments = bundle
//            bottomNav.replaceFragment(searchFragment)
            val toast = Toast.makeText(context, "Home Fragment Button", Toast.LENGTH_LONG)
            toast.show()
        }
        return root
    }

    override fun passData(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("messageInput", editTextInput)
        searchFragment.arguments = bundle

        val intent = Intent (getActivity(), DashboardFragment::class.java)
        getActivity()?.startActivity(intent)

//        val transaction: Int = supportFragmentManager.beginTransaction().replace(R.id.container, searchFragment).commit()
    }

//    private fun replaceFragment(fragment: Fragment) {
//        val fragmentManager = supportFragmentManager
//        val transaction = fragmentManager.beginTransaction()
//        transaction.replace(R.id.container,fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}