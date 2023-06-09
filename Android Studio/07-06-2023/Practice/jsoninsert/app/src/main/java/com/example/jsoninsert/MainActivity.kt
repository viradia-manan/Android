package com.example.jsoninsert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsoninsert.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {

            var name = binding.edtname.text.toString()
            var email = binding.edtemail.text.toString()
            var pass = binding.edtpass.text.toString()


            var stringRequest: StringRequest = object : StringRequest(
                Request.Method.POST,"https://mananviradia.000webhostapp.com/login_insert.php",
                Response.Listener {



                    Toast.makeText(applicationContext,"INSERTED",Toast.LENGTH_LONG).show()


                },Response.ErrorListener {


                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                })
            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String,String>()
                    map["name"]=name
                    map["email"]=email
                    map["password"]=pass
                    return map
                }
            }

            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)


        }

        binding.txt1.setOnClickListener {

            startActivity(Intent(applicationContext,LoginActivity::class.java))

        }


    }
}