package com.example.employeelogin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.employeelogin.databinding.ActivityDashBoardBinding

class DashBoardActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDashBoardBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        var name = sharedPreferences.getString("email","")

        binding.name.setText(name)

        binding.btnlogout.setOnClickListener {

            sharedPreferences.edit().clear().commit()
            finish()
            var i = Intent(applicationContext,MainActivity::class.java)
            startActivity(i)
        }
    }
}