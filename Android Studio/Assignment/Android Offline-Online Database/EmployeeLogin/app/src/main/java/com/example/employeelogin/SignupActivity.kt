package com.example.employeelogin

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
import com.example.employeelogin.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity()
{
    private lateinit var binding: ActivitySignupBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        binding.btnsignup.setOnClickListener {
            var name = binding.edtname.text.toString()
            var email = binding.edtemail.text.toString()
            var pass = binding.edtpass.text.toString()
            var cpass = binding.edtcpass.text.toString()

            if (name.length==0 && email.length==0 && pass.length==0 && cpass.length==0)
            {
                binding.edtname.setError("Please enter name")
                binding.edtemail.setError("Please enter email")
                binding.edtpass.setError("Please enter password")
                binding.edtcpass.setError("Please enter confirm password")
            }
            else if (name.length==0)
            {
                binding.edtname.setError("Please enter name")
            }
            else if (email.length==0)
            {
                binding.edtemail.setError("Please enter email")
            }
            else if (pass.length==0)
            {
                binding.edtpass.setError("Please enter password")
            }
            else if (cpass.length==0)
            {
                binding.edtcpass.setError("Please enter confirm password")
            }
            else
            {
                var stringRequest:StringRequest = object:StringRequest(Request.Method.POST,"https://mananviradia.000webhostapp.com/login_insert.php",
                    Response.Listener
                    {
                        Toast.makeText(applicationContext,"Register Successfully", Toast.LENGTH_LONG).show()
                        var i = Intent(applicationContext,MainActivity::class.java)
                        var sf: SharedPreferences.Editor = sharedPreferences.edit()
                        sf.putBoolean("USER_SESSION", true)
                        sf.putString("email", email)
                        sf.commit()
                        startActivity(i)

                    },Response.ErrorListener
                    {
                        Toast.makeText(applicationContext,"No Internet", Toast.LENGTH_LONG).show()
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
                var queue:RequestQueue = Volley.newRequestQueue(this)
                queue.add(stringRequest)
            }
        }
        binding.login.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity::class.java))
        }
    }
}