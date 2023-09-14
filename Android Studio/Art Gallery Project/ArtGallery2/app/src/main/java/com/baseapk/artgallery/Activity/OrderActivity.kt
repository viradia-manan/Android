package com.baseapk.artgallery.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Toast
import com.baseapk.artgallery.MainActivity
import retrofit2.Callback
import retrofit2.Response
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import com.baseapk.artgallery.ApiClient.ApiClient
import com.baseapk.artgallery.ApiInterface.ApiInterface
import com.baseapk.artgallery.R
import com.baseapk.artgallery.databinding.ActivityOrderBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.create

class OrderActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityOrderBinding
    lateinit var apiinterface: ApiInterface
    lateinit var sharedPreferences: SharedPreferences
    var payment = ""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)
        var email = sharedPreferences.getString("email","")

        binding.cod.setOnCheckedChangeListener(this)
        binding.online.setOnCheckedChangeListener(this)

        var i = intent
        var img = i.getStringExtra("image")
        var name = i.getStringExtra("name")
        var price = i.getStringExtra("price")

        Picasso.get().load(img).into(binding.img)
        binding.name.setText(name)
        binding.price.setText(price)

        apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        binding.order.setOnClickListener {
            var call : Call<Void> = apiinterface.payment(img.toString(), email.toString(), name.toString(),
                price.toString(),payment)
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext, "Order Successfull", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "No Intentet", Toast.LENGTH_SHORT).show()
                }

            })
        }



    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean)
    {
        if(binding.cod.isChecked)
        {
            payment = "cod"
        }

        if(binding.online.isChecked)
        {
            payment = "online"
        }
    }
}