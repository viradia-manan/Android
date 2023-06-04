package com.example.notes

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.notes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
     private lateinit var binding: ActivityMainBinding
     lateinit var list: MutableList<Model>
     lateinit var dbHelper: DbHelper
     var arrayList: ArrayList<HashMap<String, String>> = ArrayList()

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
         val view = binding.root
         setContentView(view)

         binding.search.setOnClickListener {

         }

         binding.add.setOnClickListener {

             startActivity(Intent(applicationContext, add::class.java))
         }


         list = ArrayList()
         dbHelper = DbHelper(applicationContext)

         list = dbHelper.viewdata()

         for (i in list) {
             var hm = HashMap<String, String>()
             hm["title"] = i.title
             hm["details"] = i.details

             arrayList.add(hm)
         }

         var from = arrayOf("title", "details")
         var to = intArrayOf(R.id.title, R.id.details)

         var adpater = SimpleAdapter(applicationContext, arrayList, R.layout.design, from, to)
         binding.data.adapter = adpater

        registerForContextMenu(binding.data)

     }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1 = menu!!.add(0,1,0,"UPDATE")
        var m2 = menu!!.add(0,2,0,"DELETE")

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm : AdapterView.AdapterContextMenuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo
        var id = acm.position
        var myid = list[id]


        when(item.itemId)
        {
            1->
            {
                var i = Intent(applicationContext,updtae::class.java)
                i.putExtra("id",myid.id)
                i.putExtra("title",myid.title)
                i.putExtra("details",myid.details)
                startActivity(i)
            }
            2->
            {
                var alert = AlertDialog.Builder(this)
                alert.setTitle("Are you sure you want to delete?")
                alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                    dbHelper.deletedata(myid.id)
                    startActivity(Intent(applicationContext,MainActivity::class.java))


                })
                alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.cancel()
                })

                alert.show()
            }
        }



        return super.onContextItemSelected(item)
    }
}