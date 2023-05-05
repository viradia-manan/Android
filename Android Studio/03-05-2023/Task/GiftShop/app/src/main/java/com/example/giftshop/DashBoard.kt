package com.example.giftshop

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.giftshop.databinding.ActivityDashBoardBinding


class DashBoard : AppCompatActivity(), OnItemClickListener {

    private lateinit var binding: ActivityDashBoardBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var grid:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("name",""),Toast.LENGTH_LONG).show()

        binding.logout.setOnClickListener {
            sharedPreferences.edit().clear().commit()
            finish()
            var i = Intent(applicationContext,Login::class.java)
            startActivity(i)
        }

        grid = ArrayList()

        grid.add(Model(R.drawable.watch,"Watch"))
        grid.add(Model(R.drawable.shirt,"Shirt"))
        grid.add(Model(R.drawable.phone,"Mobile"))
        grid.add(Model(R.drawable.cover,"Mobile Cover"))
        grid.add(Model(R.drawable.perfume,"Perfume"))

        var adapter = MyAdapter(applicationContext,grid)
        binding.gridView.adapter = adapter

        binding.gridView.setOnItemClickListener(
            this
        )
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p2)
        {
            0->
            {
                var i = Intent(applicationContext,Watch::class.java)
                startActivity(i)
            }
            1->
            {
                var i = Intent(applicationContext,shirt::class.java)
                startActivity(i)
            }
            2->
            {
                var i = Intent(applicationContext,Mobile::class.java)
                startActivity(i)
            }
            3->
            {
                var i = Intent(applicationContext,MobileCover::class.java)
                startActivity(i)
            }
            4->
            {
                var i = Intent(applicationContext,Perfume::class.java)
                startActivity(i)
            }
        }
    }
}