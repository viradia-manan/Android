package com.example.artgallery

import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.artgallery.databinding.ActivityMainBinding
import com.example.artgallery.ui.cart.Cart
import com.example.artgallery.ui.home.Home
import com.example.artgallery.ui.profile.Profile

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        replaceFragment(Home())

        binding.navView.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.navigation_home -> replaceFragment(Home())
                R.id.navigation_cart -> replaceFragment(Cart())
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

    override fun onBackPressed()
    {
        var alert = AlertDialog.Builder(this)
        alert.setTitle("Are you sure you want to exit?")
        alert.setPositiveButton("Yes",{ dialogInterface: DialogInterface, i: Int ->

            finishAffinity()

        })
        alert.setNegativeButton("No",{ dialogInterface: DialogInterface, i: Int ->

            dialogInterface.cancel()

        })
        alert.show()
        super.onBackPressed()
    }
}