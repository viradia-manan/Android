package com.example.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import java.util.Locale

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var btn2: Button
    lateinit var edt1: EditText
    lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn2 = findViewById(R.id.btn2)
        edt1 = findViewById(R.id.edt1)
        tts = TextToSpeech(applicationContext,this)

        btn2.setOnClickListener {

            var data = edt1.text.toString()

            tts.speak(data, TextToSpeech.QUEUE_ADD,null)
        }
    }

    override fun onInit(p0: Int) {
        tts.setLanguage(Locale.US)
        tts.setPitch(0.8F)
        tts.setSpeechRate(0.5F)
    }
}