package com.example.workindia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.workindia.databinding.ActivitySplashScreenBinding

class splashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Handler().postDelayed(Runnable {

            startActivity(Intent(applicationContext,Login::class.java))
        },3000)

    }
}