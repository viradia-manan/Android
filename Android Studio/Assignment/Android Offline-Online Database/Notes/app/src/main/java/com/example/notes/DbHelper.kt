package com.example.notes

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(var context: Context) : SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION)
{
    companion object
    {
        var DB_NAME="user.db"
        var TABLE_NAME="notes"
        var ID="id"
        var TITLE="title"
        var DETAILS="details"
        var DB_VERSION=2

    }

    override fun onCreate(db: SQLiteDatabase?)
    {
        var query ="CREATE TABLE " + TABLE_NAME + "("+ ID + " INTEGER PRIMARY KEY," + TITLE + " TEXT,"+ DETAILS + " TEXT" + ")"
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
        var db = writableDatabase
        var values = ContentValues()
        values.put(TITLE,m.title)
        values.put(DETAILS,m.details)
        var id = db.insert(TABLE_NAME,ID,values)
        return id

    }

    fun viewdata():ArrayList<Model>
    {

        var db = readableDatabase
        var arraylist = ArrayList<Model>()
        var col = arrayOf(ID, TITLE, DETAILS)
        var cursor: Cursor = db.query(TABLE_NAME,col,null,null,null,null,null,null)

        while(cursor.moveToNext())
        {
            var id = cursor.getInt(0)
            var title = cursor.getString(1)
            var details = cursor.getString(2)

            var m = Model()
            m.id=id
            m.title=title
            m.details=details

            arraylist.add(m)
        }

        return  arraylist

    }
    fun deletedata(id:Int)
    {
        var db = writableDatabase
        var deletequery = ID+" ="+id
        db.delete(TABLE_NAME,deletequery,null)

    }
    fun updatedata(m:Model)
    {
        var db = writableDatabase
        var values = ContentValues()
        values.put(ID,m.id)
        values.put(TITLE,m.title)
        values.put(DETAILS,m.details)
        var updatequery = ID+" ="+m.id
        db.update(TABLE_NAME,values,updatequery,null)
    }


}