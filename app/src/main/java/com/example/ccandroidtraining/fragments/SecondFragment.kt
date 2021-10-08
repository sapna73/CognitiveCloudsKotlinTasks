package com.example.ccandroidtraining.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ccandroidtraining.R
import com.example.ccandroidtraining.activities.replaceFragment

class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        // Get the activity and widget
        val context = activity as AppCompatActivity
        val btnNavigate: Button = view.findViewById(R.id.btnNavigate)
        val textView: TextView = view.findViewById(R.id.textView)

        // Receive the data from caller fragment/activity
        val color = arguments?.getString("color")
        val string = arguments?.getString("key1")
        color?.let {
            textView.setBackgroundColor(Color.parseColor(it))
        }
        string?.let {
            textView.setText("message from 1")
        }

        // Replace fragment
        btnNavigate.setOnClickListener {
            val name = "Jenny Jones"
            val age = 25
            val bundle = Bundle()
            bundle.putString("name",name)
            bundle.putInt("age",age)
            val fragment = FirstFragment()
            fragment.arguments = bundle

            // Call the extension function for fragment transaction
            context.replaceFragment(fragment)
        }
        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}