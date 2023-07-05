package com.example.bank

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.bank.databinding.ActivityAddClientBinding
import com.example.bank.databinding.ActivityLoginBinding

class AddClient : AppCompatActivity()
{
    private lateinit var binding:ActivityAddClientBinding
    var category = arrayOf("Bank","Municipal corporation")

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityAddClientBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var adapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item,category)
        binding.category.adapter=adapter

        binding.btnadd.setOnClickListener {

            var name = binding.edtname.text.toString()
            var mob = binding.edtmob.text.toString()
            var email = binding.edtemail.text.toString()
            var pass = binding.edtpass.text.toString()
            var cpass = binding.edtcpass.text.toString()
            var category = binding.category.selectedItem

            if (pass == cpass) {

                var stringrequest = object:StringRequest(Request.Method.POST,"https://mananviradia14.000webhostapp.com/bank/addclient.php",
                    Response.Listener {

                        Toast.makeText(applicationContext,"Add Client Successfully",Toast.LENGTH_LONG).show()


                    },Response.ErrorListener {

                        Toast.makeText(applicationContext,"Add Client Not Successfully",Toast.LENGTH_LONG).show()


                    })
                {
                    override fun getParams(): MutableMap<String, String>? {
                        var map = HashMap<String, String>()
                        map["name"] = name
                        map["mob"] = mob
                        map["email"] = email
                        map["password"] = pass
                        map["category"]= category.toString()
                        return map
                    }
                }

                var queue: RequestQueue = Volley.newRequestQueue(this)
                queue.add(stringrequest)
            }
        }

    }
}