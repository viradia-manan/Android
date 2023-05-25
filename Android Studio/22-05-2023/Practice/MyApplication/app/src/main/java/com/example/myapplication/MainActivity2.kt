package com.example.myapplication

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display.Mode
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainBinding
import io.realm.Realm
import io.realm.RealmResults

class MainActivity2 : AppCompatActivity(), AdapterView.OnItemLongClickListener {
    private lateinit var binding: ActivityMain2Binding
    lateinit var list:MutableList<Model>
    lateinit var realm: Realm


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()
        realm = Realm.getInstance(Realm.getDefaultConfiguration())

        realm.beginTransaction()

        var results:RealmResults<Model> = realm.where(Model::class.java).findAll()

        for(i in results.indices)
        {

            list.add(results[i]!!)

        }
        var adapter =MyAdapter(applicationContext,list)
        binding.list.adapter=adapter


        realm.commitTransaction()

        binding.list.setOnItemLongClickListener(this)
    }

    @SuppressLint("MissingInflatedId")
    override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean
    {

        var alertDialog= AlertDialog.Builder(this)
        alertDialog.setTitle("Select Operations?")
        alertDialog.setPositiveButton("Update", { dialogInterface: DialogInterface, i: Int ->


            var alertDialog2 = AlertDialog.Builder(this)
            var inflater = LayoutInflater.from(this)
            var view = inflater.inflate(R.layout.edit, null)
            var edit1: EditText = view.findViewById(R.id.edt1)
            var edit2: EditText = view.findViewById(R.id.edt2)

            realm.beginTransaction()
            var realmResults = realm.where(Model::class.java).findAll()

            edit1.setText(realmResults.get(position)!!.name)
            edit2.setText(realmResults.get(position)!!.num)

            realm.commitTransaction()
            alertDialog2.setView(view)
            alertDialog2.setPositiveButton("Edit", { dialogInterface: DialogInterface, i: Int ->

                var name = edit1.text.toString()
                var num = edit2.text.toString()


                realm.beginTransaction()

                list.get(position).name = name
                list.get(position).num = num


                realm.commitTransaction()
                startActivity(Intent(this, MainActivity2::class.java))



            })
            alertDialog2.show()


        })

        alertDialog.setNegativeButton("Delete", { dialogInterface: DialogInterface, i: Int ->

            realm.beginTransaction()
            var realmResults = realm.where(Model::class.java).findAll()
            realmResults.deleteFromRealm(position)
            realm.commitTransaction()
            startActivity(Intent(this, MainActivity2::class.java))
        })

        alertDialog.show()


        return true
    }
}