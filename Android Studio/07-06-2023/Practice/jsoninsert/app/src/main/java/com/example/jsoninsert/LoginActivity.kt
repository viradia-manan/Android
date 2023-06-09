package com.example.jsoninsert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsoninsert.databinding.ActivityLoginBinding
import org.json.JSONException

class LoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {

            var email = binding.edtemail.text.toString()
            var pass = binding.edtpass.text.toString()

            var stringRequest: StringRequest =object : StringRequest(
                Request.Method.POST,"https://mananviradia.000webhostapp.com/fetch_data.php",
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
                        }
                    }
                    catch (e: JSONException)
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