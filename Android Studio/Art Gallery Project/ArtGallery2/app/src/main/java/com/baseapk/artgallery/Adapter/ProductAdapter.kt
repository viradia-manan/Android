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
import com.baseapk.artgallery.Activity.ProductDetails
import com.baseapk.artgallery.Model.ProductModel
import com.baseapk.artgallery.R
import com.squareup.picasso.Picasso

class ProductAdapter(var context:Context, var list: MutableList<ProductModel>):RecyclerView.Adapter<ProductView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductView
    {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.productcard,parent,false)
        return ProductView(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductView, position: Int)
    {
        Picasso.get().load(list.get(position).product_image).into(holder.img)
        holder.name.text = list.get(position).product_name
        holder.price.text = list.get(position).product_price

        holder.img.setOnClickListener {
            var i = Intent(context, ProductDetails::class.java)
            i.putExtra("name",list.get(position).product_name)
            i.putExtra("image",list.get(position).product_image)
            i.putExtra("des",list.get(position).product_des)
            i.putExtra("price",list.get(position).product_price)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }

}

class ProductView(var itemview:View):RecyclerView.ViewHolder(itemview)
{
    var name:TextView = itemView.findViewById(R.id.pname)
    var img:ImageView = itemview.findViewById(R.id.productcardimg)
    var price:TextView = itemview.findViewById(R.id.pprice)
}
