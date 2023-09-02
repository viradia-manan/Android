package com.baseapk.artgallery.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baseapk.artgallery.Adapter.CategoryAdapter
import com.baseapk.artgallery.ApiClient.ApiClient
import com.baseapk.artgallery.Apiinterface.ApiInterface
import com.baseapk.artgallery.Model.CategoryModel
import com.baseapk.artgallery.R
import com.baseapk.artgallery.databinding.FragmentHomeBinding
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var apiinterface: ApiInterface
    lateinit var list:MutableList<CategoryModel>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        val imageList = ArrayList<SlideModel>() // Create image list

        imageList.add(SlideModel("https://img.freepik.com/free-photo/wide-angle-shot-single-tree-growing-clouded-sky-during-sunset-surrounded-by-grass_181624-22807.jpg?w=996&t=st=1693640423~exp=1693641023~hmac=1abe553d163a2b5a4e49f7c5aa81455615876ce96035b00f96f49b6b0cf6da41", "Natural"))
        imageList.add(SlideModel("https://img.freepik.com/free-photo/graffiti-children-bicycle_1122-2206.jpg?w=900&t=st=1693640470~exp=1693641070~hmac=d394be73d914ca985baab936cb131121695c6bc92f87472efbbeecfb8ddc820f", "Cycle"))
        imageList.add(SlideModel("https://img.freepik.com/premium-photo/colorful-fractal-background-creative-design_1003277-1197.jpg?size=626&ext=jpg", "Flower"))

        binding.imageSlider.setImageList(imageList)

        var layoutmanager2: RecyclerView.LayoutManager = GridLayoutManager(context,2)
        binding.category.layoutManager=layoutmanager2

        apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        list = ArrayList()

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

                Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show()

            }
        })
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}