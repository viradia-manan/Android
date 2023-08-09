package com.baseapk.artgallery.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.baseapk.artgallery.ApiClient.ApiClient
import com.baseapk.artgallery.ApiInterface.ApiInterface
import com.baseapk.artgallery.Model.RegisterModel
import com.baseapk.artgallery.LoadingDialog
import com.baseapk.artgallery.MainActivity
import com.baseapk.artgallery.R
import com.baseapk.artgallery.databinding.ActivityLoginScreenBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginScreen : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginScreenBinding
    lateinit var loadingDialog: LoadingDialog
    lateinit var apiinterface: ApiInterface
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        loadingDialog = LoadingDialog(this)

        binding.signUpTv.setOnClickListener {
            startActivity(Intent(applicationContext,SignupScreen::class.java))
        }

        textAutoCheck()

        apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("email","")!!.isEmpty())
        {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        binding.loginBtn.setOnClickListener{
            signInUser()
        }


    }

    private fun textAutoCheck()
    {
        binding.emailEt.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if (binding.emailEt.text.isEmpty()){
                    binding.emailEt.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)

                }
                else if (Patterns.EMAIL_ADDRESS.matcher(binding.emailEt.text).matches()) {
                    binding.emailEt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
                        R.drawable.ic_check
                    ), null)
                    binding.emailError.visibility = View.GONE
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {

                binding.emailEt.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (Patterns.EMAIL_ADDRESS.matcher(binding.emailEt.text).matches()) {
                    binding.emailEt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
                        R.drawable.ic_check
                    ), null)
                    binding.emailError.visibility = View.GONE
                }
            }
        })

        binding.passEt.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if (binding.passEt.text.isEmpty()){
                    binding.passEt.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)

                }
                else if (binding.passEt.text.length > 4){
                    binding.passEt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
                        R.drawable.ic_check
                    ), null)

                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {

                binding.passEt.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                binding.passwordError.visibility = View.GONE
                if (count > 4){
                    binding.passEt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
                        R.drawable.ic_check
                    ), null)

                }
            }
        })



    }

    private fun checkInput() {

        if (binding.emailEt.text.isEmpty()){
            binding.emailError.visibility = View.VISIBLE
            binding.emailError.text = "Email Can't be Empty"
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(binding.emailEt.text).matches()) {
            binding.emailError.visibility = View.VISIBLE
            binding.emailError.text = "Enter Valid Email"
            return
        }
        if(binding.passEt.text.isEmpty()){
            binding.passwordError.visibility = View.VISIBLE
            binding.passwordError.text = "Password Can't be Empty"
            return
        }

        if (binding.passEt.text.isNotEmpty() && binding.emailEt.text.isNotEmpty()){
            binding.emailError.visibility = View.GONE
            binding. passwordError.visibility = View.GONE
            signInUser()
        }
    }

    private fun signInUser() {

        loadingDialog.startLoadingDialog()
        var email = binding.emailEt.text.toString().trim()
        var password = binding.passEt.text.toString().trim()

        var call: Call<RegisterModel> = apiinterface.login(email,password)
        call.enqueue(object : Callback<RegisterModel> {
            override fun onResponse(
                call: Call<RegisterModel>,
                response: Response<RegisterModel>
            ) {
                var i = Intent(applicationContext, MainActivity::class.java)
                var sf: SharedPreferences.Editor = sharedPreferences.edit()
                sf.putBoolean("USER_SESSION", true)
                sf.putString("email", email)
                sf.putString("pass", password)
                sf.commit()
                startActivity(i)
            }

            override fun onFailure(call: Call<RegisterModel>, t: Throwable) {
                Toast.makeText(applicationContext, "Login Fail", Toast.LENGTH_SHORT).show()
            }
        })
    }
}