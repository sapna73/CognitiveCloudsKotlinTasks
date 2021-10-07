package com.example.ccandroidtraining.activities.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ccandroidtraining.`interface`.PassData
//import com.example.ccandroidtraining.activities.R
//import com.example.ccandroidtraining.activities.databinding.FragmentNotificationsBinding
import com.example.ccandroidtraining.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

//    private lateinit var passData: PassData

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    public val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val textView: TextView = binding.textNotifications
        val button: Button = binding.btnSendData11
        val editText: EditText = binding.etFragment2
        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)

        val root: View = binding.root

        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}