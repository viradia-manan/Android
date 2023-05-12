package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(var context: Context, var nameList:MutableList<Model>):BaseAdapter()
{
    override fun getCount(): Int {
        return nameList.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        var inflater:LayoutInflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.string,p2,false)

        var Name:TextView = view.findViewById(R.id.name1)

        Name.setText(nameList.get(position).name)

        return view
    }

}