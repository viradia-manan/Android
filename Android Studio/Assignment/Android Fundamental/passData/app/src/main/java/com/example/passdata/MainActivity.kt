package com.example.passdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox

class MainActivity : AppCompatActivity() {


    lateinit var chk1:CheckBox
    lateinit var chk2:CheckBox
    lateinit var chk3:CheckBox
    lateinit var btn1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chk1 = findViewById(R.id.chk1)
        chk2 = findViewById(R.id.chk2)
        chk3 = findViewById(R.id.chk3)
        btn1 = findViewById(R.id.btnorder)

        btn1.setOnClickListener {
            var total = 0
            var Mobile:StringBuffer = StringBuffer("\n Selected Mobile")

            if(chk1.isChecked)
            {
                total+=12000
                Mobile.append("\n Redmi note 10 Rs. 12,000")
            }
            if(chk2.isChecked)
            {
                total+=13500
                Mobile.append("\n Vivo y21s Rs. 13,500")
            }
            if(chk3.isChecked)
            {
                total+=12000
                Mobile.append("\n Samsung M32 Rs. 12,000")
            }

            Mobile.append("\n Total is: $total")

            var i = Intent(applicationContext,bill::class.java)
            i.putExtra("Bill",Mobile.toString())
            startActivity(i)
        }

    }
}