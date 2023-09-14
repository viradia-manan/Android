package com.baseapk.artgallery.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.baseapk.artgallery.Adapter.ProductAdapter
import com.baseapk.artgallery.ApiClient.ApiClient
import com.baseapk.artgallery.ApiInterface.ApiInterface
import com.baseapk.artgallery.Model.ProductModel
import com.baseapk.artgallery.R
import com.baseapk.artgallery.databinding.ActivityCategoryAllBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryAll : AppCompatActivity()
{
    lateinit var apiinterface: ApiInterface
    lateinit var mutableList: MutableList<ProductModel>
    private lateinit var binding: ActivityCategoryAllBinding
    lateinit var call: Call<List<ProductModel>>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryAllBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mutableList = ArrayList()

        var i = intent
        var pos = i.getIntExtra("position",101)

        apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        binding.recycler.layoutManager = GridLayoutManager(this, 2)

        when(pos)
        {
            0->
            {
                call = apiinterface.product_data()
            }
            1->
            {
                call = apiinterface.product_bw_data()
            }
            2->
            {
                call = apiinterface.product_sketch_data()
            }
        }

        call.enqueue(object: Callback<List<ProductModel>> {
            override fun onResponse(
                call: Call<List<ProductModel>>,
                response: Response<List<ProductModel>>
            ) {
                mutableList = response.body() as MutableList<ProductModel>
                val myAdapter = ProductAdapter(applicationContext, mutableList)
                binding.recycler.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_SHORT).show()
            }
        })


    }
}