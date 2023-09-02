package com.baseapk.artgallery.Activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.baseapk.artgallery.ApiClient.ApiClient
import com.baseapk.artgallery.Apiinterface.ApiInterface
import com.baseapk.artgallery.R
import com.baseapk.artgallery.databinding.ActivityProductDetailsBinding
import com.squareup.picasso.Picasso
import retrofit2.Callback
import retrofit2.Response

class ProductDetails : AppCompatActivity()
{
    private lateinit var binding: ActivityProductDetailsBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var apiinterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        var email = sharedPreferences.getString("email","")

        apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        var i = intent
        var img = i.getStringExtra("image")
        var name = i.getStringExtra("name")
        var des = i.getStringExtra("des")
        var price = i.getStringExtra("price")

        Picasso.get().load(img).into(binding.productImageProductDetailsPage)
        binding.productNameProductDetailsPage.text =name
        binding.productDesProductDetailsPage.text = des
        binding.productPriceProductDetailsPage.text = price

        binding.addToCartProductDetailsPage.setOnClickListener {

            var call:retrofit2.Call<Void> = apiinterface.fav_add(
                name.toString(), price.toString(), img.toString(), email.toString())
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: retrofit2.Call<Void>, response: Response<Void>)
                {
                    Toast.makeText(applicationContext,"Added to cart successfully", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: retrofit2.Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext,"Added to cart not successfully", Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}