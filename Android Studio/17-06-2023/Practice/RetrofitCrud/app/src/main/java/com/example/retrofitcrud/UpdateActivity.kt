package com.example.retrofitcrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitcrud.databinding.ActivityMainBinding
import com.example.retrofitcrud.databinding.ActivityUpdateBinding
import com.example.retrofitcrudex.Apiinterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdateBinding
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiinterface = ApiClient.getapiclient()!!.create(Apiinterface::class.java)

        var i = intent
        var pos = i.getStringExtra("position")
        var id = i.getIntExtra("id",101)
        var name = i.getStringExtra("name")
        var price = i.getStringExtra("price")
        apiinterface = ApiClient.getapiclient()!!.create(Apiinterface::class.java)

        binding.edtname.setText(name)
        binding.edtprice.setText(price)

        binding.btn1.setOnClickListener {

            var name = binding.edtname.text.toString()
            var price = binding.edtprice.text.toString()



            var call: Call<Void> = apiinterface.updatedata(id.toString(),name,price)
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    Toast.makeText(applicationContext,"Data Updated", Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,MainActivity2::class.java))
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext,"Error", Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}