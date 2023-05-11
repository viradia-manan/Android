package com.example.loginfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(Login())
    }

    private fun replaceFragment(fragment: Fragment): Boolean {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.frm_layout,fragment).commit()

        return true
    }
}