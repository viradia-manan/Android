package com.example.oditionapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import com.example.oditionapp.databinding.ActivitySignUpBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.database.FirebaseDatabase
import java.util.concurrent.TimeUnit

class SignUpActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivitySignUpBinding
    lateinit var verificationid:String
    private lateinit var auth: FirebaseAuth
    var gender = ""
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        FirebaseApp.initializeApp(applicationContext)
        auth = FirebaseAuth.getInstance()

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        binding.male.setOnCheckedChangeListener(this)
        binding.female.setOnCheckedChangeListener(this)

        binding.btn1.setOnClickListener {

            if(TextUtils.isEmpty(binding.edtmob.text.toString()))
            {
                Toast.makeText(this, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val phone: String = binding.edtmob.text.toString()
                sendVerificationCode(phone)
            }
        }

        binding.btn2.setOnClickListener {

            var otp = binding.edtotp.text.toString()

            if(TextUtils.isEmpty(binding.edtotp.text.toString()))
            {
                Toast.makeText(this, "Please enter a valid OTP.", Toast.LENGTH_SHORT).show()
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
                Toast.makeText(applicationContext, "Verified otp", Toast.LENGTH_SHORT).show()

                var fname = binding.edtfname.text.toString()
                var lname = binding.edtlname.text.toString()
                var email = binding.edtemail.text.toString()
                var hobbies = binding.edthobbies.text.toString()
                var pass = binding.edtpass.text.toString()
                var cpass = binding.edtcpass.text.toString()

                if (pass == cpass)
                {
                    var map = HashMap<String,String>()
                    map["fname"]=fname
                    map["lname"]=lname
                    map["email"]=email
                    map["hobbies"]=hobbies
                    map["gender"]=gender
                    map["pass"]=pass

                    var db = FirebaseDatabase.getInstance().getReference()
                        .child("tops")
                        .push()
                        .setValue(map)
                        .addOnSuccessListener{

                            Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()

                        }
                        .addOnFailureListener()
                        {
                            Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                        }
                }
            }
            else
            {
                Toast.makeText(applicationContext, "Not Verified otp", Toast.LENGTH_SHORT).show()
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
    @Suppress("DEPRECATION")
    private fun sendVerificationCode(phone: String)
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phone,60, TimeUnit.SECONDS,this,mCallBack)
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean)
    {
        if (binding.male.isChecked)
        {
            gender = "Male"
        }
        if (binding.female.isChecked)
        {
            gender = "Female"
        }
    }
}