package com.example.sharedprefrencepra

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedprefrencepra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)


        if(sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("num","")!!.isEmpty())
        {
            startActivity(Intent(this,DashboardActivity::class.java))
            finish()
        }


        binding.btn1.setOnClickListener {


            var num = binding.edt1.text.toString()
            var pass = binding.edt2.text.toString()

            var i = Intent(applicationContext,DashboardActivity::class.java)
            var sf: SharedPreferences.Editor = sharedPreferences.edit()
            sf.putBoolean("USER_SESSION",true)
            sf.putString("num",num)
            sf.putString("pass",pass)
            sf.commit()
            startActivity(i)





        }

    }
}