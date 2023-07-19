package com.example.framebyframeanimation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity()
{
    private lateinit var animationImageView: ImageView
    private lateinit var animationDrawable: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animationImageView = findViewById(R.id.animationImageView)


        animationDrawable = AnimationDrawable().apply {
            addFrame(getDrawable(R.drawable.one)!!, 100) // Replace R.drawable.frame1 with your actual frame drawables
            addFrame(getDrawable(R.drawable.two)!!, 100)
            // Add more frames as needed, adjust the duration accordingly
            isOneShot = false // Set to true if you want the animation to play only once
        }

        animationImageView.setImageDrawable(animationDrawable)
    }

    override fun onResume() {
        super.onResume()
        animationDrawable.start() // Start the animation when the activity resumes
    }

    override fun onPause() {
        super.onPause()
        animationDrawable.stop() // Stop the animation when the activity is paused to conserve resources
    }
}