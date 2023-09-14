package com.baseapk.artgallery.Fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.baseapk.artgallery.Activity.Login
import com.baseapk.artgallery.Activity.Order
import com.baseapk.artgallery.databinding.FragmentProfileBinding

class Profile : Fragment()
{
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        sharedPreferences = requireContext().getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        var email = sharedPreferences.getString("email","")

        binding.email.setText(email)

        binding.logout.setOnClickListener {
            sharedPreferences.edit().clear().commit()
            startActivity(Intent(context,Login::class.java))
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}