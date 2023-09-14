package com.baseapk.artgallery.Activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baseapk.artgallery.Adapter.CategoryAdapter
import com.baseapk.artgallery.Adapter.cancelorderAdapter
import com.baseapk.artgallery.ApiClient.ApiClient
import com.baseapk.artgallery.ApiInterface.ApiInterface
import com.baseapk.artgallery.Model.OrderModel
import com.baseapk.artgallery.databinding.ActivityOrder2Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Order : AppCompatActivity()
{
    private lateinit var binding: ActivityOrder2Binding
    lateinit var apiinterface:ApiInterface
    lateinit var mutableList: MutableList<OrderModel>
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityOrder2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mutableList = ArrayList()

        var layoutmanager2: RecyclerView.LayoutManager = GridLayoutManager(applicationContext,1)
        binding.order.layoutManager=layoutmanager2

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        var email = sharedPreferences.getString("email","")

        apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        val call: Call<List<OrderModel>> = apiinterface.view(email.toString())

        call.enqueue(object : Callback<List<OrderModel>> {
            override fun onResponse(
                call: Call<List<OrderModel>>,
                response: Response<List<OrderModel>>
            )
            {
                mutableList = response.body() as MutableList<OrderModel>
                val myAdapter = cancelorderAdapter(applicationContext, mutableList)
                binding.order.adapter = myAdapter

            }

            override fun onFailure(call: Call<List<OrderModel>>, t: Throwable) {

                Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_SHORT).show()

            }
        })
    }
}