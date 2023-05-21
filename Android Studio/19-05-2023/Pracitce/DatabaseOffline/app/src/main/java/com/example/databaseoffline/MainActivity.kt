package com.example.databaseoffline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display.Mode
import android.widget.Toast
import com.example.databaseoffline.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    lateinit var dbHelper: DbHelper
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        dbHelper = DbHelper(applicationContext)

        binding.btn1.setOnClickListener {
            var name = binding.edt1.text.toString()
            var num = binding.edt2.text.toString()

            var m = Model()
            m.name=name
            m.num=num

            var id = dbHelper.savedata(m)

            Toast.makeText(applicationContext,"Insertd "+id,Toast.LENGTH_LONG).show()
        }

        binding.btn2.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity2::class.java))
        }
    }
}