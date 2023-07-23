package com.example.smswakelockbluetooth

import android.Manifest.permission.BLUETOOTH_CONNECT
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_MUTABLE
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity()
{
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var adapter: BluetoothAdapter
    lateinit var wifi: WifiManager

    lateinit var edt1: EditText
    lateinit var edt2:EditText
    lateinit var btn3:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        adapter = BluetoothAdapter.getDefaultAdapter()
        edt1= findViewById(R.id.edtnum)
        edt2 = findViewById(R.id.edtmsg)
        btn3 = findViewById(R.id.btnmsg)

        btn1.setOnClickListener {

            if(!adapter.isEnabled)
            {
                var turnOn = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                if (ActivityCompat.checkSelfPermission(this,BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED)
                {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.

                }
                startActivityForResult(turnOn, 0)
                Toast.makeText(getApplicationContext(), "Turned ON" ,Toast.LENGTH_LONG).show();
            }

            //if(adapter.isDiscovering)

        }
        btn2.setOnClickListener {

            adapter.disable()
            Toast.makeText(getApplicationContext(), "Turned off" , Toast.LENGTH_LONG).show();
        }
        btn3.setOnClickListener {

            var num = edt1.text.toString()
            var msg = edt2.text.toString()
            var i = Intent(applicationContext,MainActivity::class.java)
            
            var pi = PendingIntent.getActivity(applicationContext,101,i,FLAG_MUTABLE)
            var sms= SmsManager.getDefault()
            sms.sendTextMessage(num,null,msg,pi,null)

        }

    }
}