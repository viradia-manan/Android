package com.example.atofandftoa

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.content.Intent

class FirstFragment : Fragment() {

    lateinit var btn:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_first, container, false)

        btn = view.findViewById(R.id.btn)

        btn.setOnClickListener {


            var i = Intent(activity,MainActivity::class.java)
            startActivity(i)

        }
        return  view
    }
}