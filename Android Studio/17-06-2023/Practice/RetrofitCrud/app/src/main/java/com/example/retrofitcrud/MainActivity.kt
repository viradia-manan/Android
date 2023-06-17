package com.example.retrofitcrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Callback
import com.example.retrofitcrud.databinding.ActivityMainBinding
import com.example.retrofitcrudex.Apiinterface
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiinterface = ApiClient.getapiclient()!!.create(Apiinterface::class.java)

        binding.btn1.setOnClickListener {
            var name = binding.edtname.text.toString()
            var price = binding.edtprice.text.toString()

            var call: retrofit2.Call<Void> = apiinterface.insertdata(name,price)
            call.enqueue(object : Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>)
                {
                    Toast.makeText(applicationContext,"Data Inserted",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,MainActivity2::class.java))
                }

                override fun onFailure(call: Call<Void>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}