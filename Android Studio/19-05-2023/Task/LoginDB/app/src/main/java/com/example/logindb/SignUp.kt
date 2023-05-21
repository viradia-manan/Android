package com.example.logindb

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.Display.Mode
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.logindb.databinding.ActivitySignUpBinding


class SignUp : AppCompatActivity()
{
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var dbHelper: DbHelper
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper = DbHelper(applicationContext)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        binding.singup.setOnClickListener{

            var name = binding.name.text.toString()
            var num = binding.num.text.toString()
            var email = binding.email.text.toString()
            var pass = binding.pass.text.toString()
            var cpass = binding.cpass.text.toString()
            var savedata = dbHelper.addUser(name,num,email,pass,cpass)



            if(pass == cpass)
            {
                val isUserAdded = dbHelper.addUser(name,num,email,pass,cpass)
                if (isUserAdded) {
                    var i = Intent(applicationContext, MainActivity::class.java)
                    var sf: SharedPreferences.Editor = sharedPreferences.edit()
                    sf.putBoolean("USER_SESSION", true)
                    sf.putString("email", email)
                    sf.commit()
                    startActivity(i)
                    Toast.makeText(applicationContext, "Register Successfull", Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(applicationContext, "Register Not Successfull", Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(applicationContext, "Password Does Not Match", Toast.LENGTH_LONG).show()
            }
        }



        binding.singin.setOnClickListener {
            startActivity(Intent(applicationContext,Login::class.java))
        }
    }

}