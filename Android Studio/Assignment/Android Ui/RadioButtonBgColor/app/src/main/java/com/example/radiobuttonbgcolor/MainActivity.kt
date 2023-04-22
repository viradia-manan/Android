package com.example.radiobuttonbgcolor

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {

    lateinit var layout:LinearLayout
    lateinit var green:RadioButton
    lateinit var black:RadioButton
    lateinit var red:RadioButton
    lateinit var blue:RadioButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        green = findViewById(R.id.rb1)
        black = findViewById(R.id.rb2)
        red = findViewById(R.id.rb3)
        blue = findViewById(R.id.rb4)
        layout = findViewById(R.id.ll)

        green.setOnClickListener {
            layout.setBackgroundColor(Color.GREEN)
        }

        black.setOnClickListener {
            layout.setBackgroundColor(Color.LTGRAY)
        }

        red.setOnClickListener {
            layout.setBackgroundColor(Color.RED)
        }

        blue.setOnClickListener {
            layout.setBackgroundColor(Color.BLUE)
        }

    }
}