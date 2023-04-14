package com.example.form

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {

    lateinit var image:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        image = findViewById(R.id.img1)

        image.setOnClickListener{
            var num = "9275459241"
            var i = Intent(Intent.ACTION_CALL)
            i.setData(Uri.parse("tel:"+num))
            startActivity(i)
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}