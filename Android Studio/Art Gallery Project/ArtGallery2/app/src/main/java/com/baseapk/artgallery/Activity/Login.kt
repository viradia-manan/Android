package com.baseapk.artgallery.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.baseapk.artgallery.ApiClient.ApiClient
import com.baseapk.artgallery.ApiInterface.ApiInterface
import com.baseapk.artgallery.MainActivity
import com.baseapk.artgallery.Model.RegisterModel
import com.baseapk.artgallery.R
import com.baseapk.artgallery.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding
    lateinit var apiinterface: ApiInterface
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("email","")!!.isEmpty())
        {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.txtsignup.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
        }

        binding.btnlogin.setOnClickListener {
            var email = binding.edtemail.text.toString()
            var pass = binding.edtpass.text.toString()

            if(email.length==0 && pass.length==0)
            {
                binding.edtemail.error = "Email is required"
                binding.edtpass.error = "Password is required"
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
                var call: Call<RegisterModel> = apiinterface.login(email,pass)
                call.enqueue(object : Callback<RegisterModel> {
                    override fun onResponse(
                        call: Call<RegisterModel>,
                        response: Response<RegisterModel>
                    ) {
                        var i = Intent(applicationContext, MainActivity::class.java)
                        var sf: SharedPreferences.Editor = sharedPreferences.edit()
                        sf.putBoolean("USER_SESSION", true)
                        sf.putString("email", email)
                        sf.putString("pass", pass)
                        sf.commit()
                        startActivity(i)
                    }

                    override fun onFailure(call: Call<RegisterModel>, t: Throwable) {
                        Toast.makeText(applicationContext, "Username and password incorrect", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}