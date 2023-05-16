package com.example.databasenameandnumber

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.security.AccessControlContext

class DbHelper(var context:Context) :SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION)
{
    companion object
    {
        var DB_NAME="userdb"
        var TABLE_NAME="info"
        var ID="id"
        var NAME="name"
        var NUMBER ="number"
        var DB_VERSION=1

    }

    override fun onCreate(db: SQLiteDatabase?)
    {
        var query ="CREATE TABLE " + TABLE_NAME + "("+ ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"+ NUMBER + " TEXT" + ")"
        db!!.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
        var upquery = "DROP TABLE IF EXISTS "+ TABLE_NAME
        db!!.execSQL(upquery)
        onCreate(db)
    }

    fun savedata(m:Model):Long
    {
        //insert data
        var db = writableDatabase
        var values = ContentValues()
        values.put(NAME,m.name)
        values.put(NUMBER,m.num)
        var id = db.insert(TABLE_NAME,ID,values)
        return id
    }

}