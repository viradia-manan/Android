package com.example.increasesizeandsmall

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    lateinit var big:Button
    lateinit var small:Button
    lateinit var name:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        big = findViewById(R.id.big)
        small = findViewById(R.id.small)
        name = findViewById(R.id.name)

        big.setOnClickListener {
            name.setTextSize(30F)
        }

        small.setOnClickListener {
            name.setTextSize(15F)
        }

    }
}