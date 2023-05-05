package com.example.giftshop

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.giftshop.databinding.ActivityIntroBinding

class Intro : AppCompatActivity()
{
    private lateinit var binding: ActivityIntroBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        binding.btn.setOnClickListener {
            var i = Intent(applicationContext,Login::class.java)
            var sf:SharedPreferences.Editor = sharedPreferences.edit()
            sf.putBoolean("USER_SESSION",true)
            sf.commit()
            startActivity(i)
        }
    }
}