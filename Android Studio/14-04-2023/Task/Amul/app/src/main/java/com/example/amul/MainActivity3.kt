package com.example.amul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        Handler().postDelayed(Runnable {
            startActivity(Intent(applicationContext,MainActivity::class.java))
        },2000)
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}