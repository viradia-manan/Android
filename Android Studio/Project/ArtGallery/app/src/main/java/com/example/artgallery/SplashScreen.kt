package com.example.artgallery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashScreen : AppCompatActivity()
{
    private val splashDuration = 4000L
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val splashLogoImageView: ImageView = findViewById(R.id.logo)

        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        splashLogoImageView.startAnimation(animation)

        Handler().postDelayed(Runnable {
            startActivity(Intent(applicationContext,LoginScreen::class.java))
        },3000)
    }
}