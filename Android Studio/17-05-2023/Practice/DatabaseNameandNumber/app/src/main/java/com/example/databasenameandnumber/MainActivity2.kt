package com.example.databasenameandnumber

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import com.example.databasenameandnumber.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    lateinit var list: MutableList<Model>
    lateinit var dbHelper: DbHelper
    var arraylist:ArrayList<HashMap<String,String>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()
        dbHelper = DbHelper(applicationContext)

        list = dbHelper.viewdata()

    for (i in list)
    {
        var hm = HashMap<String,String>()
        hm["NAME"]=i.name
        hm["NUMBER"]=i.num

        arraylist.add(hm)
    }

        var from= arrayOf("NAME","NUMBER")
        var to= intArrayOf(R.id.txt1,R.id.txt2)

        var adapter = SimpleAdapter(applicationContext,arraylist,R.layout.design,from,to)
        binding.list.adapter = adapter

        registerForContextMenu(binding.list)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1 = menu!!.add(0,1,0,"UPDATE")
        var m2 = menu!!.add(0,2,0,"DELETE")

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm:AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var id = acm.position
        var myid = list[id]

        when(item.itemId)
        {
            1->
            {

            }
            2->
            {
                var alert = AlertDialog.Builder(this)
                alert.setTitle("Are you sure want to delete?")
                alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->
                    dbHelper.deletedata(myid.id)
                    startActivity(Intent(applicationContext,MainActivity2::class.java))
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