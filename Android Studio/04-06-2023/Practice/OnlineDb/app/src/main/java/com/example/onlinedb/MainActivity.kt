package com.example.onlinedb

import android.app.DownloadManager.Request
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.onlinedb.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()


        var stringRequest=StringRequest(com.android.volley.Request.Method.POST,"https://vyasprakruti.000webhostapp.com/E-Greetings%20Project/holi_view.php",
            {
                response->
                try
                {
                    var jsonArray = JSONArray(response)
                    for(i in 0 until jsonArray.length())
                    {
                        var jsonObject = jsonArray.getJSONObject(i)

                        var name = jsonObject.getString("image")
                        // var price = jsonObject.getString("product_price")

                        var m = Model()
                        m.image=name
                        //m.product_price=price
                        list.add(m)
                    }

                }
                catch(e:JSONException)
                {
                    println(e)
                }

                var adapter = MyAdapter(applicationContext,list)
                binding.list.adapter=adapter


            })
        {
            Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
        }

        var queue:RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)

    }
}