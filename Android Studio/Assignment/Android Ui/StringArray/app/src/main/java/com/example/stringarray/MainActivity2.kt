package com.example.stringarray

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity2 : AppCompatActivity() {

    lateinit var list: ListView
    lateinit var city:MutableList<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        list = findViewById(R.id.List)
        city = ArrayList()


        var i = intent
        var data = i.getStringExtra("list")

        city.add("Rajkot")
        city.add("Surat")
        city.add("$data")

        var aa = ArrayAdapter(this,android.R.layout.simple_list_item_1,city)
        list.adapter =aa

    }
}