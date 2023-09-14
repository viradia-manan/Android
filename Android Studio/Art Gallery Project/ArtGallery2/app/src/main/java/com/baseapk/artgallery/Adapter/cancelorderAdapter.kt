package com.baseapk.artgallery.Adapter

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.baseapk.artgallery.ApiClient.ApiClient
import com.baseapk.artgallery.ApiInterface.ApiInterface
import com.baseapk.artgallery.Model.OrderModel
import com.baseapk.artgallery.R
import com.squareup.picasso.Picasso
import retrofit2.Response

class cancelorderAdapter(var context: Context, var list: MutableList<OrderModel>):RecyclerView.Adapter<OrderCancel>()
{
    private lateinit var apiinterface: ApiInterface

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderCancel {
        var layoutInflater = LayoutInflater.from(context)
        var view = layoutInflater.inflate(R.layout.cancelorderdesign,parent,false)
        return OrderCancel(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OrderCancel, @SuppressLint("RecyclerView") position: Int) {
        apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        Picasso.get().load(list.get(position).product_image).into(holder.img)
        holder.name.text = list.get(position).product_name
        holder.price.text = list.get(position).product_price

        holder.cancel.setOnClickListener {
            /*var alert = AlertDialog.Builder(context)
            alert.setTitle("Are you sure you want to cancel order?")
            alert.setPositiveButton("Yes", { dialogInterface: DialogInterface, i: Int ->
*/
                var call = apiinterface.deletedata(list.get(position).id)
                call.enqueue(object : retrofit2.Callback<Void> {
                    override fun onResponse(call: retrofit2.Call<Void>, response: Response<Void>) {
                        Toast.makeText(context, "Order Cancel", Toast.LENGTH_LONG).show()
                        list.removeAt(position)
                        notifyItemRemoved(position)
                        notifyItemRangeChanged(position, list.size)
                    }

                    override fun onFailure(call: retrofit2.Call<Void>, t: Throwable) {
                        Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show()
                    }
                })
           /* })
            alert.setNegativeButton("No", { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.cancel()
            })
            alert.show()*/
        }
    }
}

class OrderCancel(var itemview:View):RecyclerView.ViewHolder(itemview)
{
    var name :TextView = itemview.findViewById(R.id.pname)
    var img: ImageView = itemview.findViewById(R.id.oimg)
    var price :TextView = itemview.findViewById(R.id.pp)
    var cancel:TextView = itemview.findViewById(R.id.cancel)

}
