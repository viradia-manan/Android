package com.example.databaseoffline

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

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

}