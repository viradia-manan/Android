package com.example.servicereciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver: BroadcastReceiver()
{
    override fun onReceive(p0: Context?, p1: Intent?) {
        if(p1!!.action==Intent.ACTION_AIRPLANE_MODE_CHANGED)
        {
            Toast.makeText(p0,"Mode Changed", Toast.LENGTH_LONG).show()
        }
    }

}