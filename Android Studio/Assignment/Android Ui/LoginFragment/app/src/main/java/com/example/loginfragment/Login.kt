package com.example.loginfragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.loginfragment.databinding.FragmentLoginBinding

class Login() : Fragment()
{

    lateinit var reg:TextView

    @SuppressLint("ResourceType")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_login, container, false)

        reg = view.findViewById(R.id.reg)

        reg.setOnClickListener {
            replaceFragment(SignUp())
        }

        return view
    }

    private fun replaceFragment(fragment: Fragment):Boolean
    {
        val fm = requireFragmentManager()
        val ft = fm.beginTransaction()
        ft.replace(R.id.frm_layout,fragment).commit()

        return true
    }

}