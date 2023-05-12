package com.example.imagecheckhide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.imagecheckhide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.img1.setOnClickListener {
            if(binding.img1.isChecked)
            {
                binding.a.visibility = View.INVISIBLE
            }
            else
            {
                binding.a.visibility = View.VISIBLE
            }
        }

        binding.img2.setOnClickListener {
            if(binding.img2.isChecked)
            {
                binding.b.visibility = View.INVISIBLE
            }
            else
            {
                binding.b.visibility = View.VISIBLE
            }
        }

        binding.img3.setOnClickListener {
            if(binding.img3.isChecked)
            {
                binding.c.visibility = View.INVISIBLE
            }
            else
            {
                binding.c.visibility = View.VISIBLE
            }
        }

    }
}