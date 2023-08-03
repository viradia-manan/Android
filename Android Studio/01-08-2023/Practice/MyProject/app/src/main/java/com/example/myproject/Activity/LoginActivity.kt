package com.example.myproject.Activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myproject.ApiClient.ApiClient
import com.example.myproject.Apiinterface.Apinterface
import com.example.myproject.Model.RegisterModel
import com.example.myproject.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var apiinterface: Apinterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textView3.setOnClickListener {

            startActivity(Intent(applicationContext,SignupActivity::class.java))
        }
        binding.btnLogIn.setOnClickListener {


            val phone = binding.edtPhone.text.toString()
            val pass = binding.edtPassword.text.toString()

            apiinterface = ApiClient.getapiclient()!!.create(Apinterface::class.java)
            var call: Call<RegisterModel> = apiinterface.logindata(phone, pass)
            call.enqueue(object : Callback<RegisterModel> {
                override fun onResponse(
                    call: Call<RegisterModel>,
                    response: Response<RegisterModel>
                ) {
                    Toast.makeText(applicationContext, "Login success", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<RegisterModel>, t: Throwable) {
                    Toast.makeText(applicationContext, "Login Fail", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}