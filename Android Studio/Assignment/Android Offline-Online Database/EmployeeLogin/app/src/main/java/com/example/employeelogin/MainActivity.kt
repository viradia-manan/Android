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
import com.example.employeelogin.databinding.ActivityMainBinding
import org.json.JSONException

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("email","")!!.isEmpty())
        {
            startActivity(Intent(this,DashBoardActivity::class.java))
            finish()
        }

        binding.singup.setOnClickListener {
            startActivity(Intent(applicationContext,SignupActivity::class.java))
        }

        binding.btnlogin.setOnClickListener {

            var email = binding.edtemail.text.toString()
            var pass = binding.edtpass.text.toString()

            if(email.length==0 && pass.length==0)
            {
                binding.edtemail.setError("Please enter email")
                binding.edtpass.setError("Please enter password")
            }
            else if (email.length==0)
            {
                binding.edtemail.setError("Please enter email")
            }
            else if (pass.length==0)
            {
                binding.edtpass.setError("Please enter password")
            }
            else
            {
                var stringRequest:StringRequest=object :StringRequest(Request.Method.POST,"https://mananviradia.000webhostapp.com/fetch_data.php",
                    {
                            response->
                        try
                        {
                            if(response.trim().equals("0"))
                            {
                                Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_LONG).show()
                            }
                            else
                            {
                                Toast.makeText(applicationContext,"Login Success",Toast.LENGTH_LONG).show()
                                var i = Intent(applicationContext,DashBoardActivity::class.java)
                                var sf:SharedPreferences.Editor = sharedPreferences.edit()
                                sf.putBoolean("USER_SESSION",true)
                                sf.putString("email",email)
                                sf.commit()
                                startActivity(i)
                            }
                        }
                        catch (e:JSONException)
                        {
                            println(e)
                        }

                    },
                    {
                        Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()

                    })
                {
                    override fun getParams(): MutableMap<String, String>?
                    {
                        var map = HashMap<String,String>()
                        map["email"]=email
                        map["pass"]=pass

                        return map
                    }
                }


                var queue: RequestQueue = Volley.newRequestQueue(this)
                queue.add(stringRequest)


            }
        }
    }
}