package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var listview:ListView
    lateinit var list:MutableList<String>
    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listview = findViewById(R.id.list)
        list = ArrayList()
        btn = findViewById(R.id.btn1)

        list.add("a")
        list.add("b")
        list.add("c")
        list.add("d")

        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        listview.adapter = adapter


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.toolbar,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.home->
            {
                Toast.makeText(applicationContext,"Home", Toast.LENGTH_LONG).show()
            }
            R.id.about->
            {
                Toast.makeText(applicationContext,"About Us", Toast.LENGTH_LONG).show()
            }
            R.id.contact->
            {
                Toast.makeText(applicationContext,"Contact Us", Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.toolbar,menu)

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm:AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo

        when(item.itemId)
        {
            R.id.list->
            {
                Toast.makeText(applicationContext,""+acm.position, Toast.LENGTH_LONG).show()
            }
        }

        return super.onContextItemSelected(item)
    }
}