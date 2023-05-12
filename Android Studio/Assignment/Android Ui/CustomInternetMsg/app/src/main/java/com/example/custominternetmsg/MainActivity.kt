package com.example.custominternetmsg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btn1)

        btn.setOnClickListener {

            var toast = Toast(this)
            var layout= LayoutInflater.from(applicationContext)
            var view = layout.inflate(R.layout.design,null)
            toast.view=view
            toast.setGravity(Gravity.CENTER,0,0)
            toast.duration=Toast.LENGTH_LONG
            toast.show()
        }

    }
}