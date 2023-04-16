package com.example.amul

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {
    lateinit var call:ImageView
    lateinit var pi1:ImageView
    lateinit var pi3:ImageView
    lateinit var pi2:ImageView
    lateinit var pi4:ImageView
    lateinit var pi5:ImageView
    lateinit var pi6:ImageView
    lateinit var pi7:ImageView
    lateinit var pi8:ImageView
    lateinit var pi9:ImageView
    lateinit var pi10:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        call = findViewById(R.id.call)

        pi1 = findViewById(R.id.pi1)
        pi2 = findViewById(R.id.pi2)
        pi3 = findViewById(R.id.pi3)
        pi4 = findViewById(R.id.pi4)
        pi5 = findViewById(R.id.pi5)
        pi6 = findViewById(R.id.pi6)
        pi7 = findViewById(R.id.pi7)
        pi8 = findViewById(R.id.pi8)
        pi9 = findViewById(R.id.pi9)
        pi10 = findViewById(R.id.pi10)

        call.setOnClickListener{
            var num="9979770981"
            var i = Intent(Intent.ACTION_CALL)
            i.setData(Uri.parse("tel:"+num))
            startActivity(i)
        }
        pi1.setOnClickListener{
            var url = "https://amul.com/index.php"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }

        pi2.setOnClickListener{
            var url = "https://amul.com/index.php"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }
        pi3.setOnClickListener{
            var url = "https://amul.com/index.php"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }

        pi4.setOnClickListener{
            var url = "https://amul.com/index.php"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }

        pi5.setOnClickListener{
            var url = "https://amul.com/index.php"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }

        pi6.setOnClickListener{
            var url = "https://amul.com/index.php"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }

        pi7.setOnClickListener{
            var url = "https://amul.com/index.php"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }

        pi8.setOnClickListener{
            var url = "https://amul.com/index.php"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }

        pi9.setOnClickListener{
            var url = "https://amul.com/index.php"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }

        pi10.setOnClickListener{
            var url = "https://amul.com/index.php"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}