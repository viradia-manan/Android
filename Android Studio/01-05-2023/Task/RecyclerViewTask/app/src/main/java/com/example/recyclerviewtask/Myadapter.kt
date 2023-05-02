package com.example.recyclerviewtask

import android.content.Context
import android.view.Display.Mode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Myadapter(var context: Context, var list: MutableList<Model>): RecyclerView.Adapter<MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.design,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        holder.txt1.setText(list.get(position).name)
        holder.txt2.setText(list.get(position).location)
        holder.txt3.setText(list.get(position).exp)
        holder.txt4.setText(list.get(position).salary)
    }
}

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
{
    var txt1 =  itemView.findViewById<TextView>(R.id.txt1)
    var txt2 =  itemView.findViewById<TextView>(R.id.txt2)
    var txt3 =  itemView.findViewById<TextView>(R.id.txt3)
    var txt4 =  itemView.findViewById<TextView>(R.id.txt4)
}
