package com.example.bank

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.bank.databinding.ActivityViewClientBinding
import org.json.JSONArray
import org.json.JSONException

class ViewClient : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityViewClientBinding
    lateinit var list: MutableList<Model>
    var category = arrayOf("Select category","Bank","Municipal corporation")

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityViewClientBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()



        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,category)
        binding.category.adapter=adapter



        binding.category.setOnItemSelectedListener(this)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long)
    {
        var selected_category=category[p2]
        var stringRequest:StringRequest=object :StringRequest(Request.Method.POST,"https://mananviradia14.000webhostapp.com/bank/viewclient.php",
            {
                    response->
                try
                {
                    var jsonArray = JSONArray(response)
                    for(i in 0 until jsonArray.length())
                    {
                        var jsonObject = jsonArray.getJSONObject(i)

                        var name = jsonObject.getString("name")
                        var mob = jsonObject.getString("mobile")
                        var email = jsonObject.getString("email")

                        var m = Model()
                        m.name=name
                        m.mob=mob
                        m.email=email

                        list.add(m)
                    }
                }
                catch (e:JSONException)
                {
                    println(e)
                }

                var adapter = MyAdapter(applicationContext,list)
                binding.listview.adapter=adapter



            },
            {
                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()

            })
        {
            override fun getParams(): MutableMap<String, String>?
            {
                var map = HashMap<String,String>()
                map["c_name"]=selected_category
                return map
            }
        }

        var queue:RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)
        Toast.makeText(applicationContext,""+category[p2],Toast.LENGTH_LONG).show()

    }

    override fun onNothingSelected(p0: AdapterView<*>?)
    {
        Toast.makeText(applicationContext,"please select something",Toast.LENGTH_LONG).show()

    }
}