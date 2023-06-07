package com.example.todoapk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapk.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdateBinding
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper = DbHelper(applicationContext)

        var i = intent
        var id = i.getIntExtra("id",101)
        var title = i.getStringExtra("title")
        var task = i.getStringExtra("task")

        binding.edt2.setText(title)

        binding.edt1.setText(task)

        binding.btn1.setOnClickListener {

           var title = binding.edt2.text.toString()
            var task = binding.edt1.text.toString()

            var m = Model()
            m.id=id
            m.title=title
            m.task = task

            dbHelper.update(m)

            Toast.makeText(applicationContext,"Update Successfully", Toast.LENGTH_LONG).show()
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }
}