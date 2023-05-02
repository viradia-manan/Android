package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        var layout:RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyler.layoutManager = layout

        list.add(Model(R.mipmap.ic_launcher_round,"Icon 1"))
        list.add(Model(R.mipmap.ic_launcher_round,"Icon 2"))
        list.add(Model(R.mipmap.ic_launcher_round,"Icon 3"))
        list.add(Model(R.mipmap.ic_launcher_round,"Icon 4"))
        list.add(Model(R.mipmap.ic_launcher_round,"Icon 5"))
        list.add(Model(R.mipmap.ic_launcher_round,"Icon 6"))
        list.add(Model(R.mipmap.ic_launcher_round,"Icon 7"))

        var myAdapter = MyAdapter(applicationContext,list)
        binding.recyler.adapter = myAdapter
    }
}