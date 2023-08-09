package com.baseapk.artgallery.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baseapk.artgallery.R
import com.baseapk.artgallery.databinding.ActivityProductDetailsBinding
import com.baseapk.artgallery.fragment.Home
import com.squareup.picasso.Picasso

class ProductDetails : AppCompatActivity()
{
    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var img = i.getStringExtra("image")
        var name = i.getStringExtra("name")
        var des = i.getStringExtra("des")

        Picasso.get().load(img).into(binding.productImageProductDetailsPage)
        binding.productNameProductDetailsPage.text =name
        binding.productDesProductDetailsPage.text = des

        binding.backIvProfileFrag.setOnClickListener {
            var hf = Home()
            var fm = supportFragmentManager
            var ft = fm.beginTransaction()
            ft.replace(R.id.frm,hf).commit()
        }

    }
}