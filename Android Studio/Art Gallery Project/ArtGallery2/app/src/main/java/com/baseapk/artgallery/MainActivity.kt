package com.baseapk.artgallery

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.baseapk.artgallery.Fragment.Cart
import com.baseapk.artgallery.Fragment.Home
import com.baseapk.artgallery.Fragment.Profile
import com.baseapk.artgallery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(Home())

        binding.navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(Home())
                R.id.cart -> replaceFragment(Cart())
                R.id.profile -> replaceFragment(Profile())

                else -> {

                }
            }
            true
        }
    }
        private fun replaceFragment(fragment: Fragment): Boolean {
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.nav_host_fragment_activity_main,fragment).commit()

            return true
        }

        override fun onBackPressed() {
            finishAffinity()
        }
}