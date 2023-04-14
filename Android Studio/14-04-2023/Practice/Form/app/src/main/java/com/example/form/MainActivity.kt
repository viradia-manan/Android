package com.example.form

import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.Camera
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var name:EditText
    lateinit var pass:EditText
    lateinit var login:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        pass = findViewById(R.id.pass)
        login = findViewById(R.id.login)

        if(checkSelfPermission(CALL_PHONE)!=PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CALL_PHONE),101)
        }

        if(checkSelfPermission((CAMERA_SERVICE))!=PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CAMERA_SERVICE), 101)
        }

        login.setOnClickListener{

            var name_val = name.text.toString()
            var pass_val = pass.text.toString()

            if (name_val.length==0 && pass_val.length==0)
            {
                name.setError("Please Enter Name")
                pass.setError("Please Enter Password")
            }
            else if(name_val.length==0)
            {
                name.setError("Please Enter Name")
            }
            else if(pass_val.length==0)
            {
                pass.setError("Please Enter Password")
            }
            else
            {
                if(name_val.equals("manan") && pass_val.equals("1234"))
                {
                    Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()
                    var i = Intent(applicationContext,MainActivity2::class.java)
                    startActivity(i)
                }
                else
                {
                    Toast.makeText(applicationContext,"Fail",Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onBackPressed()
    {
        finishAffinity()
    }
}