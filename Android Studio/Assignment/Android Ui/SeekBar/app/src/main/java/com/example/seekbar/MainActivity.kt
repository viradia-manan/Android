package com.example.seekbar

import android.annotation.SuppressLint
import android.graphics.Color.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity()
{
    lateinit var ll:LinearLayout
    lateinit var red:ImageView
    lateinit var yellow:ImageView
    lateinit var green:ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ll = findViewById(R.id.ll)
        red = findViewById(R.id.red)
        yellow = findViewById(R.id.yellow)
        green = findViewById(R.id.green)

        red.setOnClickListener{
            ll.setBackgroundColor(RED)
        }

        yellow.setOnClickListener{
            ll.setBackgroundColor(YELLOW)
        }

        green.setOnClickListener{
            ll.setBackgroundColor(GREEN)
        }
    }
}