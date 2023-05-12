package com.example.spinnerandsearchtoolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var spin:Spinner

    var data = arrayOf("Chats","Status","Calls")

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spin = findViewById(R.id.spinner)

        spin.setOnItemSelectedListener(this)

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
    {
        Toast.makeText(applicationContext,""+data[position],Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?)
    {

    }
}