package com.example.giftshop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var context: Context, var list: MutableList<Model>):BaseAdapter()
{
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, p1: View?, parent: ViewGroup?): View {
        var inflater:LayoutInflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.desing,parent,false)

        var image: ImageView = view.findViewById(R.id.img)
        var txt1: TextView = view.findViewById(R.id.txt)

        image.setImageResource(list.get(position).img)
        txt1.setText(list.get(position).name)

        return view
    }

}