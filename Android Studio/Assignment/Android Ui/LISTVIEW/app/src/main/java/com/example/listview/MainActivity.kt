package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity()
{

    lateinit var list:ListView
    lateinit var name:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = findViewById(R.id.list)

        name = ArrayList()

        name.add(Model("Manan"))
        name.add(Model("Het"))
        name.add(Model("Kalp"))
        name.add(Model("Maitray"))
        name.add(Model("Siddharth"))
        name.add(Model("divy"))
        name.add(Model("Prince"))

        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,name)
        list.adapter = adapter

    }
}