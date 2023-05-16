package com.example.databasenameandnumber

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var dbHelper: DbHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       var edt1 = findViewById<EditText>(R.id.name)
        var edt2 = findViewById<EditText>(R.id.num)
        var insert = findViewById<Button>(R.id.insert)


        insert.setOnClickListener {

            var name = edt1.text.toString()
            var num = edt2.text.toString()

            var m = Model()
            m.name=name
            m.num=num

            var id = dbHelper.savedata(m)

            Toast.makeText(applicationContext,"Inserted"+id,Toast.LENGTH_LONG).show()
        }

    }
}