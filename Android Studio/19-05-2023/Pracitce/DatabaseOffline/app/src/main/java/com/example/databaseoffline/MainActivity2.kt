package com.example.databaseoffline

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
import com.example.databaseoffline.databinding.ActivityMain2Binding
import com.example.databaseoffline.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity()
{
    lateinit var dbHelper: DbHelper
    lateinit var list:MutableList<Model>
    private lateinit var binding: ActivityMain2Binding
    var arraylist:ArrayList<HashMap<String,String>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        dbHelper = DbHelper(applicationContext)
        list = ArrayList()

        list = dbHelper.viewdata()

        for(i in list)
        {
            var hm = HashMap<String,String>()
            hm["name"]=i.name
            hm["num"]=i.num

            arraylist.add(hm)
        }

        var from = arrayOf("name","num")
        var to = intArrayOf(R.id.txt1,R.id.txt2)

        var adapter = SimpleAdapter(applicationContext,arraylist,R.layout.design,from,to)
        binding.list.adapter = adapter

        registerForContextMenu(binding.list)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1 = menu!!.add(0,1,0,"Update")
        var m2 = menu!!.add(0,2,0,"Delete")

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm :AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var id = acm.position
        var myid = list[id]

        when(item.itemId)
        {
            1->
            {
                var i = Intent(applicationContext,UodateActivity::class.java)
                i.putExtra("id",myid.id)
                i.putExtra("name",myid.name)
                i.putExtra("number",myid.num)
                startActivity(i)
            }
            2->
            {
                var alert = AlertDialog.Builder(this)
                alert.setTitle("Are you sure you want to delete?")
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