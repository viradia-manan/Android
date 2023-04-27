package com.example.task2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.annotation.IntegerRes
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity()
{

    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var num1 = Integer.parseInt(edt1.text.toString())
            var num2 = Integer.parseInt(edt2.text.toString())

            var loop:StringBuffer = StringBuffer("The num is: ")

            for(j in num1..num2)
            {
               loop.append("\n $j")
            }

            var i = Intent(applicationContext,MainActivity2::class.java)
            i.putExtra("abc",loop.toString())
            startActivity(i)

        }
    }
}