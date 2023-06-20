package com.example.otpsignup

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.text.TextUtils
import android.widget.Toast
import com.example.otpsignup.databinding.ActivitySignUpBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

@Suppress("DEPRECATION")
class SignUpActivity : AppCompatActivity()
{

    lateinit var binding: ActivitySignUpBinding
    lateinit var verificationid:String
    private lateinit var auth: FirebaseAuth
    lateinit var apiinterface: Apiinterface
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

        binding.txt1.setOnClickListener {
            startActivity(Intent(applicationContext,LoginActivity::class.java))
        }


        binding.btn1.setOnClickListener {

            if(TextUtils.isEmpty(binding.edt3.text.toString()))
            {
                Toast.makeText(applicationContext, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val phone: String = binding.edt3.text.toString()
                sendVerificationCode(phone)
            }



        }

        binding.btn2.setOnClickListener {

            if(TextUtils.isEmpty(binding.edt4.text.toString()))
            {
                Toast.makeText(applicationContext, "Please enter a valid OTP.", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val otp: String = binding.edt4.text.toString()
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
                apiinterface = Apiclient.getapiclient()!!.create(Apiinterface::class.java)

               Toast.makeText(applicationContext,"verified",Toast.LENGTH_LONG).show()

                binding.btn3.setOnClickListener {

                    var name = binding.edt1.text.toString()
                    var email = binding.edt2.text.toString()
                    var mobile = binding.edt3.text.toString()
                    var pass = binding.edt5.text.toString()
                    var cpas = binding.edt6.text.toString()


                    if(pass == cpas)
                    {
                        var call: retrofit2.Call<Void> = apiinterface.insertdata(name,email,mobile,pass)
                        call.enqueue(object :Callback<Void>{
                            override fun onResponse(call: retrofit2.Call<Void>, response: Response<Void>) {

                                Toast.makeText(applicationContext,"SignUp Successfully",Toast.LENGTH_LONG).show()
                                startActivity(Intent(applicationContext,LoginActivity::class.java))
                            }

                            override fun onFailure(call: retrofit2.Call<Void>, t: Throwable) {
                                Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                            }
                        })

                    }
                    else
                    {
                        Toast.makeText(applicationContext,"Password does not match",Toast.LENGTH_LONG).show()
                    }

                }
            }
            else
            {
                Toast.makeText(applicationContext,"Otp Wrong",Toast.LENGTH_LONG).show()
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
                binding.edt4.setText(code)
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