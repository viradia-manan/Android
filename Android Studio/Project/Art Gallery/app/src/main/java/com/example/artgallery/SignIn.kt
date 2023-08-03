package com.example.artgallery

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.artgallery.databinding.ActivitySignInBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignIn : AppCompatActivity()
{
    private lateinit var binding: ActivitySignInBinding
    lateinit var apiinterface: Apiinterface
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiinterface = ApiClient.getapiclient()!!.create(Apiinterface::class.java)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("email","")!!.isEmpty())
        {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        binding.register.setOnClickListener {
            var reg = Register()
            var fm = supportFragmentManager
            var ft = fm.beginTransaction()
            ft.replace(R.id.fl,reg).commit()
        }

        binding.btnlogin.setOnClickListener {

            var email  = binding.edtemail.text.toString()
            var password = binding.edtpass.text.toString()

            if (email.length==0 && password.length==0)
            {
                binding.edtemail.setError("Please enter email")
                binding.edtpass.setError("Please enter password")
            }
            else if (email.length==0)
            {
                binding.edtemail.setError("Please enter email")
            }
            else if (password.length==0)
            {
                binding.edtpass.setError("Please enter password")
            }
            else
            {

                var call: Call<RegisterModel> = apiinterface.login(email,password)
                call.enqueue(object : Callback<RegisterModel> {
                    override fun onResponse(
                        call: Call<RegisterModel>,
                        response: Response<RegisterModel>
                    ) {
                        var i = Intent(applicationContext, MainActivity::class.java)
                        var sf: SharedPreferences.Editor = sharedPreferences.edit()
                        sf.putBoolean("USER_SESSION", true)
                        sf.putString("email", email)
                        sf.putString("pass", password)
                        sf.commit()
                        startActivity(i)
                    }

                    override fun onFailure(call: Call<RegisterModel>, t: Throwable) {
                        Toast.makeText(applicationContext, "Login Fail", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}