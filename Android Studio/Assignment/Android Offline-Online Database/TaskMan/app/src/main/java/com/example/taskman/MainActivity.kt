package com.example.taskman

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import com.example.taskman.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<Model>
    lateinit var dbHelper: DbHelper
    var arrayList: ArrayList<HashMap<String,String>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.add.setOnClickListener {
            startActivity(Intent(applicationContext,Add::class.java))
        }

        list = ArrayList()
        dbHelper = DbHelper(applicationContext)

        list = dbHelper.viewdata()

        for(i in list)
        {
            var hm = HashMap<String,String>()
            hm["NAME"]=i.name
            hm["DES"]=i.des
            hm["D"]=i.d
            hm["T"]=i.t

            arrayList.add(hm)
        }

        var from= arrayOf("NAME","DES","D","T")
        var to= intArrayOf(R.id.item_title,R.id.item_desc,R.id.date,R.id.time)

        var adpater = SimpleAdapter(applicationContext,arrayList,R.layout.design,from,to)
        binding.list.adapter = adpater

        registerForContextMenu(binding.list)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1 = menu!!.add(0,1,0,"High")
        var m2 = menu!!.add(0,2,0,"Average")
        var m3 = menu!!.add(0,3,0,"Low")
        var m4 = menu!!.add(0,4,0,"Update")
        var m5 = menu!!.add(0,5,0,"Delete")

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
                binding.list.setBackgroundColor(Color.RED)
            }
            2->
            {
                binding.list.setBackgroundColor(Color.GREEN)
            }
            3->
            {
                binding.list.setBackgroundColor(Color.BLUE)
            }
            4->
            {
                var i = Intent(applicationContext,UpdateActivity::class.java)
                i.putExtra("id",myid.id)
                i.putExtra("name",myid.name)
                i.putExtra("des",myid.des)
                i.putExtra("date",myid.d)
                i.putExtra("time",myid.t)
                startActivity(i)
            }
            5->
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