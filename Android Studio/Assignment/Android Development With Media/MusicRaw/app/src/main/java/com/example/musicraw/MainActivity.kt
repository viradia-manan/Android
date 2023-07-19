package com.example.musicraw

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnPlay: Button
    private lateinit var btnStop: Button
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPlay = findViewById(R.id.btnPlay)
        btnStop = findViewById(R.id.btnStop)

        mediaPlayer = MediaPlayer.create(this, R.raw.ram_siya_ram_adipurush)

        btnPlay.setOnClickListener {
            mediaPlayer.start();
        }

        btnStop.setOnClickListener {
            mediaPlayer.stop();
        }
    }

}