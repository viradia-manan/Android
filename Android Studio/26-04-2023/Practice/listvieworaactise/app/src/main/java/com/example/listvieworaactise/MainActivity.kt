package com.example.listvieworaactise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()

        list.add(model(R.drawable.pizaa,"Pizza","Spicy Pizza","250"))
        list.add(model(R.drawable.burger,"Burger","New Burger","70"))
        list.add(model(R.drawable.coffee,"Coffee","Hot Coffee","120"))

        var adapter = MyAdapter(applicationContext,list)
        listView.adapter = adapter




    }
}