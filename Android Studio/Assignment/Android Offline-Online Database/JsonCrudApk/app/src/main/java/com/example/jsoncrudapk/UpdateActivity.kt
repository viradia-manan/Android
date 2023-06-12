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
import com.example.jsoncrudapk.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var id = i.getStringExtra("id")
        binding.edt1.setText(i.getStringExtra("name"))
        binding.edt2.setText(i.getStringExtra("surname"))

        binding.btn1.setOnClickListener {

            var name = binding.edt1.text.toString()
            var surname = binding.edt2.text.toString()

            var stringrequest = object: StringRequest(
                Request.Method.POST,"https://mananviradia.000webhostapp.com/ass_update.php",
                Response.Listener {

                    Toast.makeText(applicationContext,"UPDATED",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,ViewActivity::class.java))

                },Response.ErrorListener {

                    Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()


                })
            {
                override fun getParams(): MutableMap<String, String>?
                {

                    var map = HashMap<String,String>()
                    map["id"]=id.toString()
                    map["name"]=name
                    map["surname"]=surname


                    return map
                }
            }


            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)
        }
    }
}