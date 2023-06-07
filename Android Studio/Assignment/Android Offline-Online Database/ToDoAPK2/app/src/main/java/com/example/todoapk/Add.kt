package com.example.todoapk

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapk.databinding.ActivityAddBinding
import com.example.todoapk.databinding.ActivityMainBinding

class Add : AppCompatActivity()
{
    private lateinit var binding: ActivityAddBinding
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper = DbHelper(applicationContext)

        binding.btn1.setOnClickListener {

            var title =binding.edt2.text.toString()
            var task = binding.edt1.text.toString()

            var m = Model()
            m.title=title
            m.task = task

            dbHelper.insert(m)

            Toast.makeText(applicationContext,"Insert Successfully",Toast.LENGTH_LONG).show()
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }
}