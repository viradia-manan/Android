package com.example.logindb

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.logindb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var dbHelper: DbHelper
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        var name = "Welcome " + sharedPreferences.getString("email","")

        Toast.makeText(applicationContext,""+name, Toast.LENGTH_LONG).show()

        binding.name.setText(name)

        binding.btnlogout.setOnClickListener {

            sharedPreferences.edit().clear().commit()
            finish()
            var i = Intent(applicationContext,Login::class.java)
            startActivity(i)
        }

    }

}