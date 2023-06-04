package com.example.onlinedbtask

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.jsonparsetask.R
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

        var name:TextView = view.findViewById(R.id.name)
        var realname:TextView = view.findViewById(R.id.realname)
        var team:TextView = view.findViewById(R.id.team)
        var firstappearance:TextView = view.findViewById(R.id.firstappearance)
        var createdby:TextView = view.findViewById(R.id.createdby)
        var publisher:TextView = view.findViewById(R.id.publisher)
        var image:ImageView = view.findViewById(R.id.image)
        var bio:TextView = view.findViewById(R.id.bio)


        name.setText(list.get(position).name)
        realname.setText(list.get(position).realname)
        team.setText(list.get(position).team)
        firstappearance.setText(list.get(position).firstappearance)
        createdby.setText(list.get(position).createdby)
        publisher.setText(list.get(position).publisher)
        Picasso.get().load(list.get(position).imageurl).resize(50, 50).
        centerCrop().into(image)
        bio.setText(list.get(position).bio)

        return view
    }

}