package com.example.giftshop

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.giftshop.databinding.ActivityLoginBinding
import com.example.giftshop.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("name","")!!.isEmpty())
        {
            startActivity(Intent(this,DashBoard::class.java))
            finish()
        }

        binding.signup.setOnClickListener {
            var name = binding.name.text.toString()
            var email = binding.email.text.toString()
            var pass = binding.pass.text.toString()
            var cpass = binding.cpass.text.toString()

            if(name.length==0 && email.length==0 && pass.length==0 && cpass.length==0)
            {
                binding.name.setError("Enter the name")
                binding.email.setError("Enter the email")
                binding.pass.setError("Enter the password")
                binding.cpass.setError("Enter the confirm password")
            }
            else if(name.length==0)
            {
                binding.name.setError("Enter the name")
            }
            else if(email.length==0)
            {
                binding.email.setError("Enter the email")
            }
            else if(pass.length==0)
            {
                binding.pass.setError("Enter the password")
            }
            else if(cpass.length==0)
            {
                binding.cpass.setError("Enter the confirm password")
            }
            else if(pass == cpass)
            {
                var i = Intent(applicationContext,Login::class.java)
                var sf:SharedPreferences.Editor = sharedPreferences.edit()
                sf.putBoolean("USER_SESSION",true)
                sf.putString("name",name)
                sf.putString("email",email)
                sf.putString("pass",pass)
                sf.putString("cpass",cpass)
                sf.commit()
                startActivity(i)
            }
        }

        binding.loign.setOnClickListener {
            var i = Intent(applicationContext,Login::class.java)
            startActivity(i)
        }

    }
}