package com.example.onlinedb

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

class MyAdapter(var context: Context, var list: MutableList<Model>) : BaseAdapter()
{
    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(position: Int): Any
    {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long
    {
        return  position.toLong()
    }

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        var layoutInflater = LayoutInflater.from(context)
        var view = layoutInflater.inflate(R.layout.design,parent,false)

        var txt1: ImageView = view.findViewById(R.id.img)
        //var txt2:TextView = view.findViewById(R.id.txt2)

        // txt1.setText(list.get(position).image)
        // txt2.setText(list.get(position).product_price)
        Picasso.get().load(list.get(position).image).resize(50, 50).
        centerCrop().into(txt1)
        return view
    }

}