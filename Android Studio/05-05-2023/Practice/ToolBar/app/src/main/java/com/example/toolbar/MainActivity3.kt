package com.example.toolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
    }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean
        {
            menuInflater.inflate(R.menu.option,menu)

            return super.onCreateOptionsMenu(menu)
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean
        {
            when(item.itemId)
            {
                R.id.home->
                {
                    var i = Intent(applicationContext,MainActivity::class.java)
                    startActivity(i)
                }
                R.id.about->
                {
                    var i = Intent(applicationContext,MainActivity3::class.java)
                    startActivity(i)
                }
                R.id.contact->
                {
                    var i = Intent(applicationContext,MainActivity4::class.java)
                    startActivity(i)
                }
            }

            return super.onOptionsItemSelected(item)
        }
}