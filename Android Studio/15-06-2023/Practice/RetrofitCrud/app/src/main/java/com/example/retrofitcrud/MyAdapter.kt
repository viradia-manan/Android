package com.example.retrofitcrud

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context, var list: MutableList<Model>):RecyclerView.Adapter<ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.design,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {

        holder.txt1.setText(list.get(position).product_name)
        holder.txt2.setText(list.get(position).product_price)

    }

}

class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview)
{
    var txt1: TextView = itemView.findViewById(R.id.txt1)
    var txt2: TextView = itemView.findViewById(R.id.txt2)
}