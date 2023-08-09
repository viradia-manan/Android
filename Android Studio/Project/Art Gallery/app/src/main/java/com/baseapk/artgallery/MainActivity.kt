package com.baseapk.artgallery

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.baseapk.artgallery.databinding.ActivityMainBinding
import com.baseapk.artgallery.fragment.Home

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
                R.id.homeMenu -> replaceFragment(Home())
                /*R.id.bagMenu -> replaceFragment(Bag())
                R.id.shopMenu -> replaceFragment(Shop())
                R.id.favMenu -> replaceFragment(Fav())
                R.id.profileMenu -> replaceFragment(Profile())*/

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