package com.example.jsoncrudapk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsoncrudapk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn2.setOnClickListener{
            startActivity(Intent(applicationContext,ViewActivity::class.java))
        }

        binding.btn1.setOnClickListener {

            var name = binding.edt1.text.toString()
            var surname = binding.edt2.text.toString()

            var stringrequest:StringRequest = object :StringRequest(Request.Method.POST,"https://mananviradia.000webhostapp.com/ass_insert.php",
                Response.Listener {

                    Toast.makeText(applicationContext,"Instered",Toast.LENGTH_LONG).show()

            },Response.ErrorListener {

                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()

            })
            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String,String>()
                    map["name"]=name
                    map["surname"]=surname
                    return map
                }
            }
            var queue:RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)
        }
    }
}