package com.example.passdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class bill : AppCompatActivity() {

    lateinit var text:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill)

        text = findViewById(R.id.txt)

        var i = intent
        var data = i.getStringExtra("Bill")
        text.setText(data)
    }
}