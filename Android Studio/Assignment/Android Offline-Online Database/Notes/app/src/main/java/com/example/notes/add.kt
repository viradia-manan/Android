package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.Toast
import com.example.notes.databinding.ActivityAddBinding
import com.example.notes.databinding.ActivityMainBinding

class add : AppCompatActivity()
{
    private lateinit var binding: ActivityAddBinding
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper = DbHelper(applicationContext)

        binding.submit.setOnClickListener {

            var title = binding.edt1.text.toString()
            var details = binding.edt2.text.toString()

            var m = Model()
            m.title=title
            m.details=details

            dbHelper.savedata(m)

            Toast.makeText(applicationContext,"Inserted ", Toast.LENGTH_LONG).show()
            startActivity(Intent(applicationContext,MainActivity::class.java))

        }
    }
}