package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notes.databinding.ActivityAddBinding
import com.example.notes.databinding.ActivityUpdtaeBinding

class updtae : AppCompatActivity()
{ private lateinit var binding: ActivityUpdtaeBinding
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdtaeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var id = i.getIntExtra("id",101)
        var titles = i.getStringExtra("title")
        var detail = i.getStringExtra("details")

        binding.edt1.setText(titles)
        binding.edt2.setText(detail)

        dbHelper = DbHelper(applicationContext)

        binding.submit.setOnClickListener {

            var title = binding.edt1.text.toString()
            var details = binding.edt2.text.toString()

            var m = Model()
            m.id=id
            m.title=title
            m.details=details

            dbHelper.updatedata(m)

            Toast.makeText(applicationContext,"Updated ", Toast.LENGTH_LONG).show()
            startActivity(Intent(applicationContext,MainActivity::class.java))

        }

    }
}