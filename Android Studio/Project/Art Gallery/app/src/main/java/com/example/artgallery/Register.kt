package com.example.artgallery

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.artgallery.databinding.FragmentRegisterBinding
import retrofit2.Call
import retrofit2.Response

class Register : Fragment()
{
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    lateinit var apiinterface: Apiinterface

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root

        apiinterface = ApiClient.getapiclient()!!.create(Apiinterface::class.java)

        binding.btnsignup.setOnClickListener{

            var name = binding.edtname.text.toString()
            var email  = binding.edtemail.text.toString()
            var password = binding.edtpass.text.toString()

            if (name.length==0 && email.length==0 && password.length==0)
            {
                binding.edtname.setError("Please enter name")
                binding.edtemail.setError("Please enter email")
                binding.edtpass.setError("Please enter password")
            }
            else if (name.length==0)
            {
                binding.edtname.setError("Please enter name")
            }
            else if (email.length==0)
            {
                binding.edtemail.setError("Please enter email")
            }
            else if (password.length==0)
            {
                binding.edtpass.setError("Please enter password")
            }
            else {

                var call: Call<Void> = apiinterface.signUp(name, email, password)
                call.enqueue(object : retrofit2.Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        Toast.makeText(context, "Register Successfully", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(context, SignIn::class.java))
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Toast.makeText(context, "Register Not Successfully", Toast.LENGTH_SHORT)
                            .show()
                    }

                })
            }

        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}