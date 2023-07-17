package com.example.servicereciever

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyService : Service() 
{
    override fun onCreate()
    {
        super.onCreate()
        Toast.makeText(applicationContext, "Created", Toast.LENGTH_SHORT).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int
    {
        return super.onStartCommand(intent, flags, startId)
        Toast.makeText(applicationContext, "Start Command", Toast.LENGTH_SHORT).show()
    }

    override fun onBind(intent: Intent): IBinder
    {
        TODO("Return the communication channel to the service.")
    }

    override fun onDestroy()
    {
        super.onDestroy()
        Toast.makeText(applicationContext,"Destroyed",Toast.LENGTH_LONG).show()
    }
}