package com.baseapk.artgallery.Fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baseapk.artgallery.Adapter.CartAdapter
import com.baseapk.artgallery.ApiClient.ApiClient
import com.baseapk.artgallery.ApiInterface.ApiInterface
import com.baseapk.artgallery.Model.CartModel
import com.baseapk.artgallery.R
import com.baseapk.artgallery.databinding.FragmentCartBinding
import com.baseapk.artgallery.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Cart : Fragment()
{
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    lateinit var mutableList: MutableList<CartModel>
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var apiInterface: ApiInterface

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {

        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val view = binding.root

        var layoutmanager: RecyclerView.LayoutManager = GridLayoutManager(context,1)
        binding.cartshow.layoutManager=layoutmanager

        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        sharedPreferences = requireContext().getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)
        var email =sharedPreferences.getString("email","")

        mutableList = ArrayList()

        var call: Call<List<CartModel>> = apiInterface.cart_view(email.toString())
        call.enqueue(object : Callback<List<CartModel>> {
            override fun onFailure(call: Call<List<CartModel>>, t: Throwable) {
                Toast.makeText(context, "No item cart", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<CartModel>>,
                response: Response<List<CartModel>>
            ) {
                mutableList = response.body() as MutableList<CartModel>
                var cadapter = CartAdapter(requireContext(),mutableList)
                binding.cartshow.adapter = cadapter
            }
        })

        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}