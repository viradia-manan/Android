package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.NonDisposableHandle.parent

class Myadapter(var context: Context, var list: MutableList<Model>):BaseAdapter()
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
        var View = inflater.inflate(R.layout.design,parent,false)

        var image:ImageView = View.findViewById(R.id.img)
        var text1: TextView = View.findViewById(R.id.txt1)
        var text2:TextView = View.findViewById(R.id.txt2)


        image.setImageResource(list.get(position).img)
        text1.setText(list.get(position).title)
        text2.setText(list.get(position).subtitle)


        return View
    }

}
