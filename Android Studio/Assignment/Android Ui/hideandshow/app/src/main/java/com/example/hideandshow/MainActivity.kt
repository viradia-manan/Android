package com.example.hideandshow

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var txt:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.hide)
        btn2 = findViewById(R.id.show)
        txt = findViewById(R.id.tct1)

        btn1.setOnClickListener {
            txt.visibility= View.INVISIBLE
        }

        btn2.setOnClickListener {
            txt.visibility= View.VISIBLE
        }
    }
}