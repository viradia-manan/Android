package com.example.bank

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class DetailsAdapter(var context:Context,var list:MutableList<ModelDetails>):BaseAdapter()
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
        var layout:LayoutInflater = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.detailsdesign,p2,false)

        var image:ImageView = view.findViewById(R.id.img)
        var name:TextView = view.findViewById(R.id.name)

        image.setImageResource(list.get(p0).image)
        name.setText(list.get(p0).name)

        return view
    }

}