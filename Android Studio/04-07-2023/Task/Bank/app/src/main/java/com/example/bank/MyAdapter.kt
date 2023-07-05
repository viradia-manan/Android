package com.example.bank

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(var context: Context, var list: MutableList<Model>):BaseAdapter()
{
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
        var view = layout.inflate(R.layout.viewclientdesign,p2,false)

        var name:TextView = view.findViewById(R.id.name)
        var mob:TextView = view.findViewById(R.id.mob)
        var email:TextView = view.findViewById(R.id.email)

        name.setText(list.get(p0).name)
        mob.setText(list.get(p0).mob)
        email.setText(list.get(p0).email)

        return view
    }

}