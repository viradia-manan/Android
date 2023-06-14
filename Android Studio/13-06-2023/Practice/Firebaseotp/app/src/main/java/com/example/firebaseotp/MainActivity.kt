package com.example.firebaseotp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.firebaseotp.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var verificationid:String
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        FirebaseApp.initializeApp(applicationContext)
        auth = FirebaseAuth.getInstance()

        binding.btn1.setOnClickListener {

            if(TextUtils.isEmpty(binding.edtnum.text.toString()))
            {
                Toast.makeText(this@MainActivity, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val phone: String = binding.edtnum.text.toString()
                sendVerificationCode(phone)
            }
            //var num = binding.edtnum.text.toString()




        }

        binding.btn2.setOnClickListener {

            var otp = binding.edtotp.text.toString()

            if(TextUtils.isEmpty(binding.edtotp.text.toString()))
            {
                Toast.makeText(this@MainActivity, "Please enter a valid OTP.", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val otp: String = binding.edtotp.text.toString()
                verifycode(otp)
            }

        }


    }

    private fun verifycode(otp: String)
    {

        val credential = PhoneAuthProvider.getCredential(verificationid, otp)
        signinwithcredential(credential)


    }

    private fun signinwithcredential(credential: PhoneAuthCredential)
    {
        auth.signInWithCredential(credential).addOnCompleteListener {

            if(it.isSuccessful)
            {
                var i = Intent(this,MainActivity2::class.java)
                startActivity(i)
            }
            else
            {

            }


        }
            .addOnFailureListener {

            }

    }

    var mCallBack: PhoneAuthProvider.OnVerificationStateChangedCallbacks = object: PhoneAuthProvider.OnVerificationStateChangedCallbacks()
    {
        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
            var  code = p0.getSmsCode()

            if(code!=null)
            {
                binding.edtotp.setText(code)
            }
            else
            {

                Toast.makeText(applicationContext,"Error  ", Toast.LENGTH_LONG).show();

            }
        }

        override fun onVerificationFailed(p0: FirebaseException) {

        }

        override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
            verificationid=p0
        }

    }
    private fun sendVerificationCode(phone: String)
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phone,60, TimeUnit.SECONDS,this,mCallBack)
    }
}