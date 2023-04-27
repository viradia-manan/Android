package com.example.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var listview: GridView
    lateinit var list:MutableList<model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listview = findViewById(R.id.grid)
        list = ArrayList()

        list.add(model(R.drawable.ub,"Client Book"))
        list.add(model(R.drawable.mb,"Business Book"))
        list.add(model(R.drawable.sb,"Stock Book"))
        list.add(model(R.drawable.eb,"Expense Book"))

        var adapter = MyAdapter(applicationContext,list)
        listview.adapter = adapter
    }
}