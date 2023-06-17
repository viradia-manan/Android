package com.example.retrofitcrud

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitcrudex.Apiinterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyAdapter(var context: Context, var list: MutableList<Model>):RecyclerView.Adapter<ViewHolder>()
{

    lateinit var apiinterface: Apiinterface

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        var layout = LayoutInflater.from(parent.context)
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

        holder.itemView.setOnClickListener{
            val alert = AlertDialog.Builder(holder.txt1.context)
            alert.setTitle("Select Operation?")
            alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->


                var i = Intent(context,UpdateActivity::class.java)
                i.putExtra("position",position)
                i.putExtra("id",list.get(position).product_id)
                i.putExtra("name",list.get(position).product_name)
                i.putExtra("price",list.get(position).product_price)

                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(i)

            })
            alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->


                apiinterface = ApiClient.getapiclient()!!.create(Apiinterface::class.java)
                var call: Call<Model?>?=apiinterface.deletedata(list.get(position).product_id)
                call!!.enqueue(object : Callback<Model?> {
                    override fun onResponse(call: Call<Model?>, response: Response<Model?>) {


                        Toast.makeText(it.getContext(), "deleted ", Toast.LENGTH_SHORT).show()

                        val i = Intent()
                        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK



                    }

                    override fun onFailure(call: Call<Model?>, t: Throwable) {

                    }
                })
                it.context.startActivity(Intent(it.context, MainActivity2::class.java))

            })

            alert.show()



        }

    }

}

class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview)
{
    var txt1: TextView = itemView.findViewById(R.id.txt1)
    var txt2: TextView = itemView.findViewById(R.id.txt2)
}