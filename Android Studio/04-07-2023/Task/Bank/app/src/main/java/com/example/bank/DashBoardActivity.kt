package com.example.bank

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import com.example.bank.databinding.ActivityDashBoardBinding
import com.example.bank.databinding.ActivityLoginBinding

class DashBoardActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private lateinit var binding: ActivityDashBoardBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var list:MutableList<ModelDetails>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        binding.logout.setOnClickListener {

            sharedPreferences.edit().clear().commit()
            finish()
            var i = Intent(applicationContext, LoginActivity::class.java)
            startActivity(i)

        }

        list = ArrayList()

        list.add(ModelDetails("Add Client", R.drawable.client))
        list.add(ModelDetails("View Client", R.drawable.client))

        var adapter = DetailsAdapter(applicationContext, list)
        binding.details.adapter = adapter

        binding.details.setOnItemClickListener(this)
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long)
    {
        when(p2)
        {
            0->
            {
                var i = Intent(applicationContext,AddClient::class.java)
                startActivity(i)
            }
            1->
            {
                var i = Intent(applicationContext,ViewClient::class.java)
                startActivity(i)
            }
        }
    }
}