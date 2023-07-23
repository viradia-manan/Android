package com.example.wakelock

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager

class MainActivity : AppCompatActivity()
{
    lateinit var pm:PowerManager
    lateinit var wl:PowerManager.WakeLock

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pm = getSystemService(Context.POWER_SERVICE) as PowerManager
        if (pm != null)
        {
            wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "WakeLockExample:rushabh");
        }

        wl.acquire(10*60*1000L /*10 minutes*/);
        //...
        wl.release();
    }
}