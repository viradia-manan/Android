package com.baseapk.artgallery.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.baseapk.artgallery.Activity.ProductDetails
import com.baseapk.artgallery.Model.CategoryModel
import com.baseapk.artgallery.Model.imageslider
import com.baseapk.artgallery.R
import com.squareup.picasso.Picasso

class ImageAdapter(var context: Context, var list: MutableList<imageslider>): RecyclerView.Adapter<ImageSliderView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSliderView {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.imageslider, parent, false)
        return ImageSliderView(view)
    }

    override fun onBindViewHolder(holder: ImageSliderView, position: Int) {
        Picasso.get().load(list.get(position).img).into(holder.img)
        holder.name.text = list.get(position).name

        holder.btn.setOnClickListener {
            var i = Intent(context,ProductDetails::class.java)
            i.putExtra("name",list.get(position).name)
            i.putExtra("image",list.get(position).img)
            i.putExtra("des",list.get(position).des)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class ImageSliderView(var itemview:View) : RecyclerView.ViewHolder(itemview)
{
    var name:TextView = itemView.findViewById(R.id.productNoteCover)
    var img:ImageView = itemView.findViewById(R.id.productImage_coverPage)
    var btn:Button = itemView.findViewById(R.id.productCheck_coverPage)

}
