package com.example.fragmentlifecycle

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class lifecycle : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lifecycle, container, false)
    }

    @SuppressLint("MissingSuperCall")
    override fun onStart() {
        Toast.makeText(activity,"Start",Toast.LENGTH_LONG).show()
    }

    @SuppressLint("MissingSuperCall")
    override fun onResume() {
        Toast.makeText(activity,"Resume",Toast.LENGTH_LONG).show()
    }

    @SuppressLint("MissingSuperCall")
    override fun onPause() {
        Toast.makeText(activity,"Pause",Toast.LENGTH_LONG).show()
    }

    @SuppressLint("MissingSuperCall")
    override fun onStop() {
        Toast.makeText(activity,"Stop",Toast.LENGTH_LONG).show()
    }

    @SuppressLint("MissingSuperCall")
    override fun onDestroy() {
        Toast.makeText(activity,"Destroy",Toast.LENGTH_LONG).show()
    }

}