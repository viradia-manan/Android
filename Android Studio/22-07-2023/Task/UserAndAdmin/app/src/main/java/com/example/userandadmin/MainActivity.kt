package com.example.userandadmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity()
{
    lateinit var btnadmin: Button
    lateinit var btnuser:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnadmin = findViewById(R.id.btnadmin)
        btnuser = findViewById(R.id.btnuser)

        btnadmin.setOnClickListener {
            startActivity(Intent(applicationContext,AdminActivity::class.java))
        }

        btnuser.setOnClickListener {
            startActivity(Intent(applicationContext,UserActivity::class.java))
        }
    }
}