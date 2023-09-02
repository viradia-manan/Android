package com.baseapk.artgallery.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.baseapk.artgallery.Activity.CategoryAll
import com.baseapk.artgallery.Apiinterface.ApiInterface
import com.baseapk.artgallery.Model.CategoryModel
import com.baseapk.artgallery.Model.ProductModel
import com.baseapk.artgallery.R
import com.squareup.picasso.Picasso
import retrofit2.Call

class CategoryAdapter(var context:Context, var list: MutableList<CategoryModel>):RecyclerView.Adapter<CategoryView>()
{
    lateinit var call: Call<List<CategoryModel>>
    private lateinit var apiInterface: ApiInterface

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryView
    {
        var layoutInflater = LayoutInflater.from(context)
        var view = layoutInflater.inflate(R.layout.categorydesign,parent,false)
        return CategoryView(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: CategoryView, position: Int)
    {
        Picasso.get().load(list.get(position).image).into(holder.img)
        holder.txt.text = list.get(position).name

       holder.img.setOnClickListener {
           var i = Intent(context, CategoryAll::class.java)
           i.putExtra("position",position)
           i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
           context.startActivity(i)
       }
    }

}

class CategoryView (itemview: View) : RecyclerView.ViewHolder(itemview)
{

    var img: ImageView = itemview.findViewById(R.id.image)
    var txt: TextView = itemview.findViewById(R.id.cname)

}
