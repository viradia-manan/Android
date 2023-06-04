package com.example.taskman

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(var context: Context):SQLiteOpenHelper(context, db_name,null, db_version)
{
    companion object
    {
        var db_name = "user"
        var table_name = "info"
        var id = "id"
        var name = "name"
        var des = "des"
        var d = "d"
        var t = "t"
        var db_version = 4
    }

    override fun onCreate(p0: SQLiteDatabase?)
    {
        var query ="CREATE TABLE " + table_name + "(" + id + " INTEGER PRIMARY KEY," + name + " TEXT,"+ des + " TEXT," + d + " TEXT," + t + " TEXT" + ")"
        p0!!.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int)
    {
        var upquery = "DROP TABLE IF EXISTS "+ table_name
        p0!!.execSQL(upquery)
        onCreate(p0)
    }

    fun insert(m:Model): Long
    {
        var db = writableDatabase
        var values = ContentValues()
        values.put(id,m.id)
        values.put(name,m.name)
        values.put(des,m.des)
        values.put(d,m.d)
        values.put(t,m.t)
        var id = db.insert(table_name, null,values)
        return id
    }

    fun viewdata():ArrayList<Model>
    {
        var db = readableDatabase
        var arraylist = ArrayList<Model>()
        var col = arrayOf(id,name,des,d,t)
        var cursor: Cursor = db.query(table_name,col,null,null,null,null,null,null)

        while(cursor.moveToNext())
        {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var des = cursor.getString(2)
            var d = cursor.getString(3)
            var t = cursor.getString(4)

            var m = Model()
            m.id=id
            m.name=name
            m.des= des
            m.d=d
            m.t=t


            arraylist.add(m)
        }

        return  arraylist

    }
    fun deletedata(Id:Int)
    {

        var db = writableDatabase
        var deletequery = id+" ="+Id
        db.delete(table_name,deletequery,null)

    }
    fun updatedata(m:Model)
    {
        var db = writableDatabase
        var values = ContentValues()
        values.put(id,m.id)
        values.put(name,m.name)
        values.put(des,m.des)
        values.put(d,m.d)
        values.put(t,m.t)
        var updatequery = id+" ="+m.id
        db.update(table_name,values,updatequery,null)
    }


}