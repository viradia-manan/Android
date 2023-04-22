package com.example.bg

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    lateinit var btn:Button
    lateinit var bg:LinearLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bg = findViewById(R.id.ll)

        btn = findViewById(R.id.btn1)

        btn.setOnClickListener{
            bg.setBackgroundColor(Color.BLUE)
        }
    }
}