package com.example.atofandftoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var btn:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.img1)

        btn.setOnClickListener {

            var f1 = FirstFragment()
            var fm:FragmentManager = supportFragmentManager
            var ft:FragmentTransaction = fm.beginTransaction()
            ft.replace(R.id.btn1,f1).commit()

        }

    }
}