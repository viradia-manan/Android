package com.example.logindb

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.logindb.databinding.ActivityLoginBinding


class Login : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding
    lateinit var dbHelper: DbHelper
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.singup.setOnClickListener {
            startActivity(Intent(applicationContext,SignUp::class.java))
        }

        dbHelper = DbHelper(applicationContext)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("email","")!!.isEmpty())
        {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        binding.signin.setOnClickListener {

            var email = binding.email.text.toString()
            var pass = binding.pass.text.toString()


            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass))
            {
                Toast.makeText(applicationContext,"Invalid username and password", Toast.LENGTH_LONG).show()
            }
            else
            {
                val checkuser = dbHelper.checkUser(email,pass)
                if(checkuser == true)
                {
                    var i = Intent(applicationContext,MainActivity::class.java)
                    var sf:SharedPreferences.Editor = sharedPreferences.edit()
                    sf.putBoolean("USER_SESSION",true)
                    sf.putString("email",email)
                    sf.commit()
                    startActivity(i)
                    Toast.makeText(applicationContext,"Login SuccessFull", Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(applicationContext,"Wrong Username", Toast.LENGTH_LONG).show()
                }
            }

        }

    }

}