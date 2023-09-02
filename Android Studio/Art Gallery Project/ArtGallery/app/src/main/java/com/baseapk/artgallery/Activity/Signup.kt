package com.baseapk.artgallery.Activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.baseapk.artgallery.ApiClient.ApiClient
import com.baseapk.artgallery.Apiinterface.ApiInterface
import com.baseapk.artgallery.MainActivity
import com.baseapk.artgallery.Model.RegisterModel
import com.baseapk.artgallery.R
import com.baseapk.artgallery.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Signup : AppCompatActivity()
{
    private lateinit var binding: ActivitySignupBinding
    lateinit var apiinterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        binding.btnsignup.setOnClickListener {
            var name = binding.edtname.text.toString()
            var email = binding.edtemail.text.toString()
            var pass = binding.edtpass.text.toString()

            if(name.length==0 && email.length==0 && pass.length==0)
            {
                binding.edtname.error = "Name is required"
                binding.edtemail.error = "Email is required"
                binding.edtpass.error = "Password is required"
            }
            else if (name.length==0)
            {
                binding.edtname.error = "Name is required"
            }
            else if (email.length==0)
            {
                binding.edtemail.error = "Email is required"
            }
            else if (pass.length==0)
            {
                binding.edtpass.error = "Password is required"
            }
            else
            {
                var call: Call<Void> = apiinterface.signUp(name, email, pass)
                call.enqueue(object : retrofit2.Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        Toast.makeText(applicationContext, "Register Successfully", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(applicationContext, Login::class.java))
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Toast.makeText(applicationContext, "Register Not Successfully", Toast.LENGTH_SHORT)
                            .show()
                    }

                })
            }
        }

        binding.txtlogin.setOnClickListener{
            startActivity(Intent(applicationContext, Login::class.java))
        }
    }
}