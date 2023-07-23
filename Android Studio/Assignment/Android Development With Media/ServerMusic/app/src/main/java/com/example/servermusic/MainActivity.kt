package com.example.servermusic

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException


class MainActivity : AppCompatActivity(), MediaPlayer.OnPreparedListener {
    lateinit var imageButton:Button
    lateinit var mediaPlayer:MediaPlayer
    var url = "https://mananviradia14.000webhostapp.com/music/always_sunny_in_wrexha.mp3"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageButton = findViewById(R.id.imageButton)


    }

    fun playSong(view: View?) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer()
            try {
                mediaPlayer.setDataSource(url)
                mediaPlayer.prepareAsync()
                mediaPlayer.setOnPreparedListener(this)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        } else {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause()
            } else {
                mediaPlayer.start()
            }
        }
    }

    override fun onPrepared(mp: MediaPlayer?) {
        mediaPlayer.start()
    }
}