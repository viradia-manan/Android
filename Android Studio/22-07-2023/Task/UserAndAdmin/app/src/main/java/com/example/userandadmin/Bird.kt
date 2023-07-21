package com.example.userandadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException

class Bird : AppCompatActivity()
{
    lateinit var list: MutableList<Model>
    lateinit var grid: GridView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bird)

        list = ArrayList()

        grid = findViewById(R.id.grid)

        var stringRequest= StringRequest(
            Request.Method.GET,"https://mananviradia14.000webhostapp.com/A_U/viewbird.php",
            {
                    response->
                try
                {
                    var jsonArray = JSONArray(response)
                    for(i in 0 until jsonArray.length())
                    {
                        var jsonObject = jsonArray.getJSONObject(i)

                        var image = jsonObject.getString("image")
                        var name = jsonObject.getString("name")
                        // var price = jsonObject.getString("product_price")

                        var m = Model()
                        m.img=image
                        m.name=name
                        //m.product_price=price
                        list.add(m)
                    }

                }
                catch(e: JSONException)
                {
                    println(e)
                }

                var adapter = Myadapter(applicationContext,list)
                grid.adapter=adapter


            })
        {
            Toast.makeText(applicationContext,"No Internet", Toast.LENGTH_LONG).show()
        }

        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)
    }
}