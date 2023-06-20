package com.example.otpsignup

import android.content.Context
import android.content.SharedPreferences
import android.view.Display.Mode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(var context: Context, var list: MutableList<Model>):BaseAdapter()
{
    lateinit var sharedPreferences: SharedPreferences

    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(p0: Int): Any
    {
        return p0
    }

    override fun getItemId(p0: Int): Long
    {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View
    {
        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.nav_header_main,p2,false)

        var email :TextView = view.findViewById(R.id.textView)

        email.setText(list.get(p0).email)

        return view
    }

}