package com.example.workindia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.workindia.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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
                if(email.equals("viradiamanan@gmail.com") && pass.equals("1234"))
                {
                    Toast.makeText(applicationContext, "Login Successfull", Toast.LENGTH_LONG).show()
                    var i = Intent(applicationContext,MainActivity::class.java)
                    startActivity(i)
                }
                else
                {
                    Toast.makeText(applicationContext, "Login Fail", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.signup.setOnClickListener {
            var i = Intent(applicationContext,register::class.java)
            startActivity(i)
        }
    }
}