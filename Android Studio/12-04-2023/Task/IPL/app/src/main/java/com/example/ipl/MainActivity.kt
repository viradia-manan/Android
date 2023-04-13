package com.example.ipl

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    lateinit var mi:ImageView
    lateinit var rcb:ImageView
    lateinit var gt:ImageView
    lateinit var dc:ImageView
    lateinit var rr:ImageView

    lateinit var n_mi:TextView
    lateinit var n_rcb:TextView
    lateinit var n_gt:TextView
    lateinit var n_dc:TextView
    lateinit var n_rr:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mi

        mi = findViewById(R.id.mi)

        mi.setOnClickListener {
            var i = Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)
        }


        n_mi = findViewById(R.id.teammi)

        n_mi.setOnClickListener{
            var mi_url = "https://www.iplt20.com/teams/mumbai-indians"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(mi_url))
            startActivity(i)
        }

        //rcb

        rcb = findViewById(R.id.rcb)

        rcb.setOnClickListener {
            var i = Intent(applicationContext,MainActivity3::class.java)
            startActivity(i)
        }

        n_rcb = findViewById(R.id.teamrcb)

        n_rcb.setOnClickListener{
            var rcb_url = "https://www.iplt20.com/teams/royal-challengers-bangalore"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(rcb_url))
            startActivity(i)
        }

        //gt

        gt = findViewById(R.id.gt)

        gt.setOnClickListener {
            var i = Intent(applicationContext,MainActivity4::class.java)
            startActivity(i)
        }

        n_gt = findViewById(R.id.teamgt)

        n_gt.setOnClickListener{
            var gt_url = "https://www.iplt20.com/teams/gujarat-titans"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(gt_url))
            startActivity(i)
        }

        //dc

        dc = findViewById(R.id.dc)

        dc.setOnClickListener {
            var i = Intent(applicationContext,MainActivity5::class.java)
            startActivity(i)
        }

        n_dc = findViewById(R.id.teamdc)

        n_dc.setOnClickListener{
            var dc_url = "https://www.iplt20.com/teams/delhi-capitals"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(dc_url))
            startActivity(i)
        }

        //rr

        rr = findViewById(R.id.rr)

        rr.setOnClickListener {
            var i = Intent(applicationContext,MainActivity6::class.java)
            startActivity(i)
        }

        n_rr = findViewById(R.id.teamrr)

        n_rr.setOnClickListener{
            var rr_url = "https://www.iplt20.com/teams/rajasthan-royals"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(rr_url))
            startActivity(i)
        }
    }
}