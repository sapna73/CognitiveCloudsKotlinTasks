package com.example.ccandroidtraining.activities.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
//import com.example.ccandroidtraining.activities.R
//import com.example.ccandroidtraining.activities.databinding.FragmentDashboardBinding
import com.example.ccandroidtraining.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    var displayMessage: String? = ""

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val textView: TextView = binding.textDashboard
        val root: View = binding.root
        displayMessage = arguments?.getString("messageInput")
        textView.text = displayMessage

        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}