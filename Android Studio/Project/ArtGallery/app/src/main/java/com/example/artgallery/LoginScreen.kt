package com.example.artgallery

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.artgallery.databinding.ActivityLoginScreenBinding
import com.example.artgallery.ui.dashboard.DashboardFragment
import com.example.artgallery.ui.home.HomeFragment

class LoginScreen : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginScreenBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)


        if(sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("email_number","")!!.isEmpty())
        {
            startActivity(Intent(this,HomeFragment::class.java))
            finish()
        }

        binding.txtsignup.setOnClickListener {
            var sa = SignUpActivity()
            var fm:FragmentManager = supportFragmentManager
            var ft:FragmentTransaction = fm.beginTransaction()
            ft.replace(R.id.ll,sa).commit()
        }

        binding.txtlogin.setOnClickListener {
            var email = binding.edtemail.text.toString()
            var pass = binding.edtpass.text.toString()

            var i = Intent(applicationContext,MainActivity::class.java)
            var sf:SharedPreferences.Editor = sharedPreferences.edit()
            sf.putBoolean("USER_SESSION",true)
            sf.putString("email",email)
            sf.putString("pass",pass)
            sf.commit()
            startActivity(i)
        }
    }

    override fun onBackPressed()
    {
        finishAffinity()
    }
}