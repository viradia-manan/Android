package com.baseapk.artgallery.Adapter

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.baseapk.artgallery.Activity.OrderActivity
import com.baseapk.artgallery.ApiClient.ApiClient
import com.baseapk.artgallery.ApiInterface.ApiInterface
import com.baseapk.artgallery.Model.CartModel
import com.baseapk.artgallery.R
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartAdapter(var context: Context, var list: MutableList<CartModel>): RecyclerView.Adapter<CartView>()
{
    private lateinit var apiinterface: ApiInterface

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartView {
        var layoutInflater = LayoutInflater.from(context)
        var view = layoutInflater.inflate(R.layout.cartitemdesign,parent,false)
        return CartView(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CartView, @SuppressLint("RecyclerView") position: Int)
    {
        apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        Picasso.get().load(list.get(position).img).into(holder.img)
        holder.name.text = list.get(position).product_name
        holder.price.text = list.get(position).product_price

        holder.remove.setOnClickListener {

            var alert = AlertDialog.Builder(context)
            alert.setTitle("Are you sure you want to delete?")
            alert.setPositiveButton("Yes",{ dialogInterface: DialogInterface, i: Int ->

                var call = apiinterface.deletecart(list.get(position).product_email)
                call.enqueue(object :Callback<Void>
                {
                    override fun onResponse(call: Call<Void>, response: Response<Void>)
                    {
                        Toast.makeText(context,"Item Deleted",Toast.LENGTH_LONG).show()
                        list.removeAt(position)
                        notifyItemRemoved(position)
                        notifyItemRangeChanged(position, list.size)
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable)
                    {
                        Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show()
                    }
                })
            })
            alert.setNegativeButton("No",{ dialogInterface: DialogInterface, i: Int ->
                dialogInterface.cancel()
            })
            alert.show()
        }

        holder.order.setOnClickListener {
            var intent = Intent(context, OrderActivity::class.java)
            intent.putExtra("email",list.get(position).product_email)
            intent.putExtra("name",list.get(position).product_name)
            intent.putExtra("price",list.get(position).product_price)
            intent.putExtra("image",list.get(position).img)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}

class CartView(itemView: View):RecyclerView.ViewHolder(itemView)
{
    var img:ImageView = itemView.findViewById(R.id.img)
    var name:TextView = itemView.findViewById(R.id.pname)
    var price:TextView = itemView.findViewById(R.id.pp)
    var remove:TextView = itemView.findViewById(R.id.remove)
    var order:TextView = itemView.findViewById(R.id.order)

}
