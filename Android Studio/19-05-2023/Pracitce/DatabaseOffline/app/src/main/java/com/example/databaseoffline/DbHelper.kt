package com.example.databaseoffline

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.view.Display.Mode

class DbHelper(var context:Context):SQLiteOpenHelper(context,db_name,null,db_version)
{

    companion object
    {
        var db_name = "user"
        var table_name = "info"
        var id= "id"
        var name = "name"
        var number = "num"
        var db_version = 1
    }

    override fun onCreate(db: SQLiteDatabase?)
    {

        var query ="CREATE TABLE " + table_name + "("+ id + " INTEGER PRIMARY KEY," + name + " TEXT,"+ number + " TEXT" + ")"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int)
    {
        var upquery = "DROP TABLE IF EXITS " + table_name
        db!!.execSQL(upquery)
        onCreate(db)
    }
    
    fun savedata(m:Model):Long
    {
        var db = writableDatabase
        var values = ContentValues()
        values.put(name,m.name)
        values.put(number,m.num)
        var id = db.insert(table_name,id,values)
        return id
    }

    fun viewdata(): ArrayList<Model>
    {
        var db = readableDatabase
        var arraylist = ArrayList<Model>()
        var col = arrayOf(id, name, number)
        var cursor:Cursor = db.query(table_name,col,null,null,null,null,null,null)

        while (cursor.moveToNext())
        {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var num = cursor.getString(2)

            var m = Model()
            m.id=id
            m.name=name
            m.num=num

            arraylist.add(m)

        }

        return arraylist

    }

    fun deletedata(Id:Int)
    {
        var db = writableDatabase
        var deletequery = id + " ="+ Id
        db.delete(table_name,deletequery,null)
    }

    fun updatedata(m:Model)
    {
        var db = writableDatabase
        var values = ContentValues()
        values.put(id,m.id)
        values.put(name,m.name)
        values.put(number,m.num)
        db.insert(table_name,id,values)
        var update = id+ " ="+m.id
        db.update(table_name,values,update,null)
    }


}