package com.example.bank

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.bank.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        binding.btnsignup.setOnClickListener {
            var name = binding.edtname.text.toString()
            var mob = binding.edtmobile.text.toString()
            var email = binding.edtemail.text.toString()
            var address = binding.edtaddress.text.toString()
            var pass = binding.edtpass.text.toString()
            var cpass = binding.edtcpass.text.toString()

            if(name.length==0 && mob.length==0 && email.length==0 && address.length==0 && pass.length==0 && cpass.length==0)
            {
                binding.edtname.setError("Please Enter Name")
                binding.edtmobile.setError("Please Enter Mobile No.")
                binding.edtemail.setError("Please Enter Email")
                binding.edtaddress.setError("Please Enter Address")
                binding.edtpass.setError("Please Enter Password")
                binding.edtcpass.setError("Please Enter Confirm Password")
            }
            else if(name.length==0)
            {
                binding.edtname.setError("Please Enter Name")
            }
            else if(mob.length==0)
            {
                binding.edtmobile.setError("Please Enter Mobile No.")
            }
            else if(email.length==0)
            {
                binding.edtemail.setError("Please Enter Email")
            }
            else if(address.length==0)
            {
                binding.edtaddress.setError("Please Enter Address")
            }
            else if(pass.length==0)
            {
                binding.edtpass.setError("Please Enter Password")
            }
            else if(cpass.length==0)
            {
                binding.edtcpass.setError("Please Enter Confirm Password")
            }
            else
            {
                if (pass == cpass)
                {
                    var stringRequest:StringRequest = object :StringRequest(Request.Method.POST,"https://mananviradia14.000webhostapp.com/bank/Login.php",Response.Listener {

                        Toast.makeText(applicationContext,"Sign Up Successfully",Toast.LENGTH_LONG).show()

                    },Response.ErrorListener {
                        Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                    })
                    {
                        override fun getParams(): MutableMap<String, String>?
                        {
                            var map = HashMap<String,String>()
                            map["name"]=name
                            map["mob"]=mob
                            map["add"]=address
                            map["email"]=email
                            map["password"]=pass
                            return map
                        }
                    }
                    var queue:RequestQueue = Volley.newRequestQueue(this)
                    queue.add(stringRequest)
                }
            }
        }

        binding.txtlogin.setOnClickListener{
            startActivity(Intent(applicationContext,LoginActivity::class.java))
        }
    }
}