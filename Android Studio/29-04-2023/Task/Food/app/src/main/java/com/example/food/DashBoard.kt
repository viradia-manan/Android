package com.example.food

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.example.food.databinding.ActivityDashBoardBinding

class DashBoard : AppCompatActivity() {

    private lateinit var binding: ActivityDashBoardBinding
    var map = HashMap<String, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        map.put("Burger", R.drawable.burger)
        map.put("Pizza", R.drawable.pizza)
        map.put("Fench Fries", R.drawable.frenchfries)
        map.put("Pasta", R.drawable.pasta)

        for (name in map.keys) {
            val textSliderView = TextSliderView(this)
            textSliderView
                .description(name)
                .image(map.get(name)!!)
            binding.slider.addSlider(textSliderView)
        }

        binding.ff.setOnClickListener {
            var i = Intent(applicationContext,Details::class.java)
            startActivity(i)
        }

        binding.burger.setOnClickListener {
            var i = Intent(applicationContext,Details::class.java)
            startActivity(i)
        }

        binding.pasta.setOnClickListener {
            var i = Intent(applicationContext,Details::class.java)
            startActivity(i)
        }

        binding.pizza.setOnClickListener {
            var i = Intent(applicationContext,Details::class.java)
            startActivity(i)
        }
    }
}