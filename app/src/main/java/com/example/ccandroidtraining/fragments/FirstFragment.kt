package com.example.ccandroidtraining.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ccandroidtraining.R
import com.example.ccandroidtraining.activities.replaceFragment

class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        // Get the activity and widget
        val context = activity as AppCompatActivity
        val btnNavigate: Button = view.findViewById(R.id.btnNavigate)
        val textView: EditText = view.findViewById(R.id.textView)

        // Get the arguments from the caller fragment/activity
        val name = arguments?.getString("name")
        val age = arguments?.getInt("age")

        name?.let {
            textView.append("\nName: $name")
        }

        age?.let {
            textView.append("\nAge: $it")
        }

        // Replace fragment
        btnNavigate.setOnClickListener {
            // Pass data to fragment
            val args = Bundle()
            // Send string data as key value format
            args.putString("color","#FFFF00")
            args.putString("key1", textView.text.toString())
            val fragment = SecondFragment()
            fragment.arguments = args

            context.replaceFragment(fragment)
        }
        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}