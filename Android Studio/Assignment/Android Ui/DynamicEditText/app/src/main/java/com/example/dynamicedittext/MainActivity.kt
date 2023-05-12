package com.example.dynamicedittext

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool

class MainActivity : AppCompatActivity()
{

    lateinit var edt1:EditText
    lateinit var ll:LinearLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        ll = findViewById(R.id.ll)
        var btn = findViewById<Button>(R.id.buttonShow)

        btn.setOnClickListener {
            var num = Integer.parseInt(edt1.text.toString())

            for (i in 1..num)
            {
                val editText = EditText(this)
                editText.setHint("Enter EditText $i")
                editText.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                ll.addView(editText)
            }
        }
    }
}