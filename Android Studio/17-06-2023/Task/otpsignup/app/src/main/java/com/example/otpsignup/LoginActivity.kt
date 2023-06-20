package com.example.otpsignup

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.ui.AppBarConfiguration
import com.example.otpsignup.databinding.ActivityLoginBinding
import com.example.otpsignup.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding
    lateinit var apiinterface: Apiinterface
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiinterface = Apiclient.getapiclient()!!.create(Apiinterface::class.java)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)


        if(sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("email","")!!.isEmpty())
        {
            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        }

        binding.btn1.setOnClickListener {

            var email = binding.edt1.text.toString()
            var pass = binding.edt2.text.toString()

            var call: Call<Void> = apiinterface.login(email,pass)
            call.enqueue(object: Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>)
                {
                    Toast.makeText(applicationContext,"Login Successfully",Toast.LENGTH_LONG).show()
                    var i = Intent(applicationContext,MainActivity::class.java)
                    var sf:SharedPreferences.Editor = sharedPreferences.edit()
                    sf.putBoolean("USER_SESSION",true)
                    sf.putString("email",email)
                    sf.putString("pass",pass)
                    sf.commit()
                    startActivity(i)
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                }
            })
        }

        binding.txt1.setOnClickListener {
            startActivity(Intent(applicationContext,SignUpActivity::class.java))
        }

    }
}