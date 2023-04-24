package com.example.stringarray

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var edt:EditText
    lateinit var btn:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt= findViewById(R.id.edt)
        btn = findViewById(R.id.btn)


        btn.setOnClickListener {

        var txt = edt.text.toString()

            var i = Intent(applicationContext,MainActivity2::class.java)
            i.putExtra("list",txt.toString())
            startActivity(i)

        }

    }
}