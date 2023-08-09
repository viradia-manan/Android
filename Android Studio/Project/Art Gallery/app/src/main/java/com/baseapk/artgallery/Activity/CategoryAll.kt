package com.baseapk.artgallery.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.baseapk.artgallery.Adapter.CategoryAdapter
import com.baseapk.artgallery.Adapter.ImageAdapter
import com.baseapk.artgallery.ApiClient.ApiClient
import com.baseapk.artgallery.ApiInterface.ApiInterface
import com.baseapk.artgallery.Model.CategoryModel
import com.baseapk.artgallery.Model.imageslider
import com.baseapk.artgallery.databinding.ActivityCategoryAllBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryAll : AppCompatActivity()
{
    lateinit var apiinterface: ApiInterface
    lateinit var mutableList: MutableList<CategoryModel>
    private lateinit var binding: ActivityCategoryAllBinding
    lateinit var call: Call<List<CategoryModel>>
    lateinit var sliderlist : MutableList<imageslider>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryAllBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        binding.recycler.layoutManager = GridLayoutManager(this, 2)

        var i = intent
        var pos  =  i.getIntExtra("position",101)


       /* when(pos)
        {
            0->
            {
                call = apiinterface.product_data()
            }
        }*/

        call.enqueue(object: Callback<List<CategoryModel>> {
            override fun onResponse(
                call: Call<List<CategoryModel>>,
                response: Response<List<CategoryModel>>
            ) {
                mutableList = response.body() as MutableList<CategoryModel>
                val myAdapter = CategoryAdapter(applicationContext, mutableList)
                binding.recycler.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })


    }
}