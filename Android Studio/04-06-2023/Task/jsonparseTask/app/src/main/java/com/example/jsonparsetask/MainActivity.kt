package com.example.jsonparsetask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsonparsetask.databinding.ActivityMainBinding
import com.example.onlinedbtask.Model
import com.example.onlinedbtask.MyAdapter
import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()


        var stringRequest= StringRequest(
            Request.Method.POST,"https://simplifiedcoding.net/demos/marvel/",
            {
                response->
                try
                {
                    var jsonArray = JSONArray(response)
                    for(i in 0 until jsonArray.length())
                    {
                        var jsonObject = jsonArray.getJSONObject(i)

                        var name = jsonObject.getString("name")
                        var realname = jsonObject.getString("realname")
                        var team = jsonObject.getString("team")
                        var firstappearance = jsonObject.getString("firstappearance")
                        var createdby = jsonObject.getString("createdby")
                        var publisher = jsonObject.getString("publisher")
                        var imageurl = jsonObject.getString("imageurl")
                        var bio = jsonObject.getString("bio")


                        var m = Model()
                        m.name=name
                        m.realname=realname
                        m.team=team
                        m.firstappearance=firstappearance
                        m.createdby=createdby
                        m.publisher=publisher
                        m.imageurl=imageurl
                        m.bio=bio

                        list.add(m)
                    }

                }
                catch(e: JSONException)
                {
                    println(e)
                }

                var adapter = MyAdapter(applicationContext,list)
                binding.list.adapter=adapter


            })
        {
            Toast.makeText(applicationContext,"No Internet", Toast.LENGTH_LONG).show()
        }

        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)

    }
}