package com.example.loginfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.loginfragment.databinding.FragmentSignUpBinding

class SignUp() : Fragment()
{
    lateinit var login:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        val view: View= inflater.inflate(R.layout.fragment_sign_up, container, false)

        login = view.findViewById(R.id.login)

        login.setOnClickListener {
            replaceFragment(Login())
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