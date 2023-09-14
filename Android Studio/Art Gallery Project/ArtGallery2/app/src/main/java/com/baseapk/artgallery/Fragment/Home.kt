package com.baseapk.artgallery.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baseapk.artgallery.Activity.Order
import com.baseapk.artgallery.Adapter.CategoryAdapter
import com.baseapk.artgallery.ApiClient.ApiClient
import com.baseapk.artgallery.ApiInterface.ApiInterface
import com.baseapk.artgallery.Model.CategoryModel
import com.baseapk.artgallery.R
import com.baseapk.artgallery.databinding.FragmentHomeBinding
import com.denzcoskun.imageslider.models.SlideModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Home : Fragment()
{
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

        imageList.add(SlideModel(R.drawable.art1, "ColourFull Art"))
        imageList.add(SlideModel(R.drawable.art2, "ColourFull Art"))
        imageList.add(SlideModel(R.drawable.art3, "ColourFull Art"))

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

        binding.showorder.setOnClickListener {
            startActivity(Intent(context,Order::class.java))
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}