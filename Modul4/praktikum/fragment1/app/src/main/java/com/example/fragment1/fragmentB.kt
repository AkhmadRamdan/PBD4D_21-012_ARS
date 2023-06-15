package com.example.fragment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class fragmentB : Fragment() {
    var output : String ?= ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        val textView : TextView = view.findViewById(R.id.massage)
        output = arguments?.getString("massage")
        textView.text = output
        return  view
    }
}