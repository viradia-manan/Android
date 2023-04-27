package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var list: MutableList<Model>
    lateinit var listView:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()

        list.add(Model(R.drawable.twitter,"Twitter","Apk"))
        list.add(Model(R.drawable.yt,"Youtube","Apk"))
        list.add(Model(R.drawable.p,"Printrest","Apk"))
        list.add(Model(R.drawable.fb,"Facebook","Apk"))
        list.add(Model(R.drawable.i,"Instagram","Apk"))

        var adapter = Myadapter(applicationContext,list)
        listView.adapter = adapter


    }
}