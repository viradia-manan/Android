package com.example.artgallery.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.denzcoskun.imageslider.models.SlideModel
import com.example.artgallery.R
import com.example.artgallery.databinding.FragmentHomeBinding

class Home : Fragment()
{
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root


    val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.art))
        imageList.add(SlideModel(R.drawable.artrwo))
        imageList.add(SlideModel(R.drawable.lion))

        binding.imageSlider.setImageList(imageList)
        return view
    }

}