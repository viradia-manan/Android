package com.example.oditionapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.oditionapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("email","")!!.isEmpty())
        {
            startActivity(Intent(this,DashBoard::class.java))
            finish()
        }

        binding.txtsignup.setOnClickListener {
            startActivity(Intent(applicationContext,SignUpActivity::class.java))
        }

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnlogin.setOnClickListener {
            var email = binding.edtemail.text.toString()
            var pass = binding.edtpass.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                        var i = Intent(applicationContext,DashBoard::class.java)
                        var sf:SharedPreferences.Editor = sharedPreferences.edit()
                        sf.putBoolean("USER_SESSION",true)
                        sf.putString("email",email)
                        sf.putString("pass",pass)
                        sf.commit()
                        startActivity(i)
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}