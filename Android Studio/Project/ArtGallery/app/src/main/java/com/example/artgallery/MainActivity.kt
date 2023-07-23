package com.example.artgallery

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.artgallery.databinding.ActivityMainBinding
import com.example.artgallery.ui.cart.Cart
import com.example.artgallery.ui.favourite.Favourite
import com.example.artgallery.ui.home.HomeFragment
import com.example.artgallery.ui.profile.Profile

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.navView.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.navigation_home -> replaceFragment(HomeFragment())
                R.id.navigation_dashboard -> replaceFragment(Favourite())
                R.id.navigation_notifications -> replaceFragment(Cart())
                R.id.navigation_profile -> replaceFragment(Profile())
                else -> {

                }
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment): Boolean {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.frm_layout,fragment).commit()

        return true
    }
}