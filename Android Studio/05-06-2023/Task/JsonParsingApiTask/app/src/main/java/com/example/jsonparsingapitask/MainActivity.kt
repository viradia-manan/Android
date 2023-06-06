package com.example.jsonparsingapitask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsonparsingapitask.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        var stringRequest = StringRequest(
            Request.Method.GET, "https://orieshot.000webhostapp.com/view.php",
            { response ->
                try {

                    var jsonArray = JSONArray(response)
                    for(i in 0 until jsonArray.length())
                    {
                        var jsonObject = jsonArray.getJSONObject(i)

                        var name = jsonObject.getString("name")
                        var surname = jsonObject.getString("surname")
                        var email = jsonObject.getString("email")

                        var m = Model()
                        m.name=name
                        m.surname=surname
                        m.email=email

                        list.add(m)
                    }


                    var adapter = MyAdapter(applicationContext, list)
                    binding.list.adapter = adapter


                } catch (e: JSONException) {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
                }


            })
        {
            Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()
        }

        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)


    }
}