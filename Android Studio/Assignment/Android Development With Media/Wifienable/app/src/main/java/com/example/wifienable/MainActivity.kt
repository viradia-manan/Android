package com.example.wifienable

import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity()
{
    lateinit var enableButton:Button
    lateinit var disableButton:Button
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enableButton = findViewById(R.id.on)
        disableButton = findViewById(R.id.off)

        enableButton.setOnClickListener {
            val wifi =
                applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
            wifi.isWifiEnabled = true
        }

        disableButton.setOnClickListener {
            val wifi =
                applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
            wifi.isWifiEnabled = false
        }

    }
}