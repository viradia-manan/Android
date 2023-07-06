package com.example.firebasecrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebasecrud.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        FirebaseApp.initializeApp(applicationContext)
        setContentView(view)

        binding.btninsert.setOnClickListener {

            var name = binding.edt1.text.toString()
            var email = binding.edt2.text.toString()
            var pass = binding.edt3.text.toString()

            var map = HashMap<String,String>()
            map["name"]=name
            map["email"]=email
            map["password"]=pass

            var db = FirebaseDatabase.getInstance().getReference()
                .child("user")
                .push()
                .setValue(map)
                .addOnSuccessListener{

                    Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext, MainActivity2::class.java))

                }
                .addOnFailureListener()
                {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                }

        }
        binding.btnview.setOnClickListener {

            startActivity(Intent(applicationContext, MainActivity2::class.java))


        }
    }


}