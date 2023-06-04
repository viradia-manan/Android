package com.example.roomdb.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.roomdb.Database.MyDb
import com.example.roomdb.Entity.User
import com.example.roomdb.MainActivity
import com.example.roomdb.R
import com.example.roomdb.databinding.ActivityAdduserBinding

class Adduser : AppCompatActivity()
{
    private lateinit var binding: ActivityAdduserBinding
    var db:MyDb? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdduserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        db = Room.databaseBuilder(applicationContext,
            MyDb::class.java, "myDatabase").allowMainThreadQueries().build()

        binding.btninsert.setOnClickListener {

            var name = binding.edtname.text.toString()
            var pass = binding.edtpass.text.toString()

            var m = User()
            m.name=name
            m.pass=pass

            db!!.daoClass().insertdata(m)
            Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()

        }

        binding.btnview.setOnClickListener {

            startActivity(Intent(applicationContext, MainActivity::class.java))

        }
    }
}