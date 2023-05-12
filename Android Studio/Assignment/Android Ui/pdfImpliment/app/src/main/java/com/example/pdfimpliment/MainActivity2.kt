package com.example.pdfimpliment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var text:TextView
    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        text = findViewById(R.id.txt)
        btn = findViewById(R.id.btn)

        var i = Intent(Intent.ACTION_PICK)
        var data = i.getStringExtra("pdf")
        text.setText(data)

        btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            var data = i.getStringExtra("pdf")
            startActivity(intent)

        }

    }
}