package com.example.splashanimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity()
{
    private val splashDuration = 2000L

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashLogoImageView: ImageView = findViewById(R.id.splashLogoImageView)

        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        splashLogoImageView.startAnimation(animation)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splashDuration)
    }
}