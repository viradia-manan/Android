package com.example.pdfimpliment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity()
{

    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.pdf)

        btn.setOnClickListener(View.OnClickListener {
            val path = Environment.getExternalStorageDirectory().toString()
            val uri = Uri.parse(path)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(uri, "*/*")
            startActivity(intent)
        })

    }



}