package com.example.databasenameandnumber

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.databasenameandnumber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var dbHelper: DbHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var edt1 = findViewById<EditText>(R.id.name)
        var edt2 = findViewById<EditText>(R.id.num)
        var insert = findViewById<Button>(R.id.insert)

        dbHelper = DbHelper(applicationContext)

        insert.setOnClickListener {

            var name = edt1.text.toString()
            var num = edt2.text.toString()

            var m = Model()
            m.name=name
            m.num=num

            var id = dbHelper.savedata(m)

            Toast.makeText(applicationContext,"Inserted "+id,Toast.LENGTH_LONG).show()
        }
        binding.view.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity2::class.java))
        }

    }
}