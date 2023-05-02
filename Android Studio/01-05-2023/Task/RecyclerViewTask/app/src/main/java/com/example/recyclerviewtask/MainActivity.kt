package com.example.recyclerviewtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        var layout:RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyler.layoutManager = layout

        list.add(Model("Android Developer","Rajkot","Experience: Fresher","Rs. 10000"))
        list.add(Model("PHP Developer","Rajkot","Experience: Fresher","Rs. 10000"))
        list.add(Model("Web Developer","Rajkot","Experience: Fresher","Rs. 10000"))
        list.add(Model("Laravel Developer","Rajkot","Experience: Fresher","Rs. 10000"))
        list.add(Model("Flutter Developer","Rajkot","Experience: Fresher","Rs. 10000"))
        list.add(Model("Fullstack Web Developer","Rajkot","Experience: Fresher","Rs. 10000"))

        var adapter = Myadapter(applicationContext,list)
        binding.recyler.adapter = adapter

    }
}