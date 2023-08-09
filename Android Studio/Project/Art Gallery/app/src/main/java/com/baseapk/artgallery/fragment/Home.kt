package com.baseapk.artgallery.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baseapk.artgallery.Adapter.CategoryAdapter
import com.baseapk.artgallery.Adapter.ImageAdapter
import com.baseapk.artgallery.ApiClient.ApiClient
import com.baseapk.artgallery.ApiInterface.ApiInterface
import com.baseapk.artgallery.Model.CategoryModel
import com.baseapk.artgallery.Model.imageslider
import com.baseapk.artgallery.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var apiinterface: ApiInterface
    lateinit var list:MutableList<CategoryModel>
    lateinit var imglist:MutableList<imageslider>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        var layoutmanager: RecyclerView.LayoutManager = GridLayoutManager(context,1)
        binding.csale.layoutManager=layoutmanager

        var layoutmanager2: RecyclerView.LayoutManager = GridLayoutManager(context,10)
        binding.category.layoutManager=layoutmanager2

        apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        list = ArrayList()

        imglist = ArrayList()

        val call: Call<List<CategoryModel>> = apiinterface.category_data()

        call.enqueue(object : Callback<List<CategoryModel>> {
            override fun onResponse(
                call: Call<List<CategoryModel>>,
                response: Response<List<CategoryModel>>
            )
            {
                list = response.body() as MutableList<CategoryModel>
                val myAdapter = CategoryAdapter(context!!, list)
                binding.category.adapter = myAdapter

            }

            override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {


            }
        })

        val imgcall : Call<List<imageslider>> = apiinterface.imgslider()
        imgcall.enqueue(object:Callback<List<imageslider>>{
            override fun onResponse(
                call: Call<List<imageslider>>,
                response: Response<List<imageslider>>
            ) {
                imglist = response.body() as MutableList<imageslider>
                val imgAdapter = ImageAdapter(context!!,imglist)
                binding.csale.adapter = imgAdapter
            }

            override fun onFailure(call: Call<List<imageslider>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}