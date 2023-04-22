package com.example.clacradio

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var add:RadioButton
    lateinit var sub:RadioButton
    lateinit var multi:RadioButton
    lateinit var div:RadioButton
    lateinit var btn1:Button
    lateinit var txt1:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        add = findViewById(R.id.add)
        sub = findViewById(R.id.sub)
        multi = findViewById(R.id.multi)
        div = findViewById(R.id.div)
        btn1 = findViewById(R.id.btn1)
        txt1 = findViewById(R.id.txt1)

        btn1.setOnClickListener {

            var num1 = Integer.parseInt(edt1.text.toString())
            var num2 = Integer.parseInt(edt2.text.toString())


            if(add.isChecked)
            {
                var result = num1+num2
                txt1.setText("$result")
            }
            else if(sub.isChecked)
            {
                var result = num1-num2
                txt1.setText("$result")
            }
            else if(multi.isChecked)
            {
                var result = num1*num2
                txt1.setText("$result")
            }
            else if(div.isChecked)
            {
                var result = num1/num2
                txt1.setText("$result")
            }
        }



    }
}