package com.example.listvieworaactise

import android.content.Context
import android.view.Display.Mode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var context:Context,var list: MutableList<model>) : BaseAdapter()
{
    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(position: Int): Any
    {
        return position
    }

    override fun getItemId(position: Int): Long
    {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        var inflater:LayoutInflater = LayoutInflater.from(context)
        var convertView = inflater.inflate(R.layout.design,parent,false)

        var image:ImageView = convertView.findViewById(R.id.img)
        var txt1:TextView = convertView.findViewById(R.id.txt1)
        var txt2:TextView = convertView.findViewById(R.id.txt2)
        var txt3:TextView = convertView.findViewById(R.id.txt3)

        image.setImageResource(list.get(position).img)
        txt1.setText(list.get(position).name)
        txt2.setText(list.get(position).des)
        txt3.setText(list.get(position).price)


        return convertView
    }

}