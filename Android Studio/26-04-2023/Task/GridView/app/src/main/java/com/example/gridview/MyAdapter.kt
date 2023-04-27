package com.example.gridview

import android.annotation.SuppressLint
import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonDisposableHandle.parent

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
        var txt1:TextView = convertView.findViewById(R.id.txt)

        image.setImageResource(list.get(position).image)
        txt1.setText(list.get(position).name)


        return convertView
    }

}
