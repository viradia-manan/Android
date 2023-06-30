package com.example.bank

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.bank.databinding.ActivityDashBoardBinding
import com.example.bank.databinding.ActivityLoginBinding

class DashBoardActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDashBoardBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        binding.logout.setOnClickListener{

            sharedPreferences.edit().clear().commit()
            finish()
            var i = Intent(applicationContext,LoginActivity::class.java)
            startActivity(i)

        }
    }
}