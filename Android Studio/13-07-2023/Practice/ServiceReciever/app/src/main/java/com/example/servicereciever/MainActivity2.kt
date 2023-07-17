package com.example.servicereciever

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var m1 = MyReceiver()
        var i = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(m1,i)
    }
}