package com.baseapk.artgallery.Activity

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.baseapk.artgallery.ApiClient.ApiClient
import com.baseapk.artgallery.ApiInterface.ApiInterface
import com.baseapk.artgallery.databinding.ActivitySignupScreenBinding
import retrofit2.Call
import retrofit2.Response

class SignupScreen : AppCompatActivity()
{
    private lateinit var binding: ActivitySignupScreenBinding
    lateinit var progressDialog: ProgressDialog
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    lateinit var apiinterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        binding.signInTvSignUpPage.setOnClickListener {
            startActivity(Intent(applicationContext,LoginScreen::class.java))
        }
        progressDialog = ProgressDialog(this)

        binding.signUpBtnSignUpPage.setOnClickListener {
            signIn()
        }
    }

    private fun signIn()
    {
        var name = binding.nameEtSignUpPage.text.toString()
        var email  = binding.emailEtSignUpPage.text.toString()
        var password = binding.PassEtSignUpPage.text.toString()
        var cpassword = binding.cPassEtSignUpPage.text.toString()

        if (name.length==0 && email.length==0 && password.length==0)
        {
            binding.nameEtSignUpPage.setError("Please enter name")
            binding.emailEtSignUpPage.setError("Please enter email")
            binding.PassEtSignUpPage.setError("Please enter password")
            binding.cPassEtSignUpPage.setError("Please enter confirm password")
        }
        else if (name.length==0)
        {
            binding.nameEtSignUpPage.setError("Please enter name")
        }
        else if (email.length==0)
        {
            binding.emailEtSignUpPage.setError("Please enter email")
        }
        else if (password.length==0)
        {
            binding.PassEtSignUpPage.setError("Please enter password")
        }
        else if (cpassword.length==0)
        {
            binding.cPassEtSignUpPage.setError("Please enter confirm password")
        }
        else {

            var call: Call<Void> = apiinterface.signUp(name, email, password)
            call.enqueue(object : retrofit2.Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext, "Register Successfully", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext, LoginScreen::class.java))
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "Register Not Successfully", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }
}