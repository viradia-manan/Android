package com.example.workindia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.workindia.databinding.ActivityRegisterBinding
import com.example.workindia.databinding.ActivitySplashScreenBinding
import com.example.workindia.ui.home.HomeFragment
import kotlin.math.sign

class register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


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
            else
            {
                Toast.makeText(applicationContext,"Details Submit Successfull",Toast.LENGTH_LONG).show()

                var i = Intent(applicationContext,Login::class.java)
                startActivity(i)
            }
        }

        binding.loign.setOnClickListener {
            var i = Intent(applicationContext,Login::class.java)
            startActivity(i)
        }
    }
}