package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import io.realm.Realm

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        realm = Realm.getInstance(Realm.getDefaultConfiguration())

        binding.btn1.setOnClickListener {

            var name = binding.edt1.text.toString()
            var num = binding.edt2.text.toString()

            realm.beginTransaction()

            var m = realm.createObject(Model::class.java)
            m.name=name
            m.num=num

            realm.commitTransaction()

            Toast.makeText(applicationContext,"Inserted",Toast.LENGTH_LONG).show()
        }

        binding.btn2.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity2::class.java))
        }
    }

}