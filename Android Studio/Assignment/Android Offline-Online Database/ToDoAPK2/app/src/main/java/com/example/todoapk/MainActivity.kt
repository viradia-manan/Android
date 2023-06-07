package com.example.todoapk

import android.content.DialogInterface

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.todoapk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var dbHelper: DbHelper
    lateinit var list: MutableList<Model>
    var arrayList :ArrayList<HashMap<String,String>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.add.setOnClickListener {
            startActivity(Intent(applicationContext, Add::class.java))
        }


        list = ArrayList()
        dbHelper = DbHelper(applicationContext)

        list = dbHelper.view()

        for (i in list)
        {
            var hm = HashMap<String,String>()
            hm["task"]=i.task
            hm["com"]= i.title

            arrayList.add(hm)
        }

        var from = arrayOf("com","task")
        var to = intArrayOf(R.id.title,R.id.task)

        var myadapter = SimpleAdapter(applicationContext,arrayList,R.layout.design,from,to)
        binding.data.adapter = myadapter

        registerForContextMenu(binding.data)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1 = menu!!.add(0,1,0,"Update")
        var m2 = menu!!.add(0,2,0,"Delete")

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
                var i = Intent(applicationContext,UpdateActivity::class.java)
                i.putExtra("id",myid.id)
                i.putExtra("title",myid.title)
                i.putExtra("task",myid.task)
                startActivity(i)
            }
            2->
            {
                var alert = AlertDialog.Builder(this)
                alert.setTitle("Are you sure you want to delete?")
                alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                    dbHelper.delete(myid.id)
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