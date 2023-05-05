package com.example.giftshop

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.giftshop.databinding.ActivityIntroBinding
import com.example.giftshop.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("name","")!!.isEmpty())
        {
            startActivity(Intent(this,DashBoard::class.java))
            finish()
        }

        binding.login.setOnClickListener {
            var email = binding.email.text.toString()
            var pass = binding.pass.text.toString()

            if(email.length==0 && pass.length==0)
            {
                binding.email.setError("Enter the email")
                binding.pass.setError("Enter the password")
            }
            else if(email.length==0)
            {
                binding.email.setError("Enter the email")
            }
            else if(pass.length==0)
            {
                binding.pass.setError("Enter the password")
            }
            else
            {
                var i = Intent(applicationContext,DashBoard::class.java)
                var sf:SharedPreferences.Editor = sharedPreferences.edit()
                sf.putBoolean("USER_SESSION",true)
                sf.putString("email",email)
                sf.putString("pass",pass)
                sf.commit()
                startActivity(i)
            }
        }

        binding.signup.setOnClickListener {
            var i = Intent(applicationContext,SignUp::class.java)
            startActivity(i)
        }

    }
}