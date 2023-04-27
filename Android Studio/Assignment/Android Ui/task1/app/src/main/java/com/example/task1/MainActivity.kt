package com.example.task1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var num:EditText
    lateinit var result:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num = findViewById(R.id.edt1)
        result = findViewById(R.id.result)




        num.setOnClickListener {

            var edt = num.text.toString()

            var reversed = edt.reversed()

            result.setText(reversed)
        }




    }
}