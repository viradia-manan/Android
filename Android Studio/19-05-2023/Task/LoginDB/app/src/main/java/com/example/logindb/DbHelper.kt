package com.example.logindb

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(var context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION)

{
    companion object {
        var DB_NAME = "user.db"
        var TABLE_NAME = "info"
        var ID = "id"
        var NAME = "name"
        var NUMBER = "number"
        var EMAIL = "email"
        var PASS = "pass"
        var CPASS = "cpass"
        var DB_VERSION = 6
    }


    override fun onCreate(db: SQLiteDatabase?) {
        var query =
            "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY," + NAME + " TEXT," + NUMBER + " TEXT," + EMAIL + " TEXT," + PASS + " TEXT," + CPASS + " TEXT" + ")"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var upquery = "DROP TABLE IF EXISTS " + TABLE_NAME
        db!!.execSQL(upquery)
        onCreate(db)
    }


    fun addUser(name: String,num:String,email:String, pass: String,cpass:String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME,name)
        values.put(NUMBER, num)
        values.put(EMAIL, email)
        values.put(PASS, pass)
        values.put(CPASS, cpass)
        val result = db.insert(TABLE_NAME, ID, values)
        db.close()
        return result != -1L
    }


    fun checkUser(username: String, password: String): Boolean {
        val columns = arrayOf(ID)
        val db = this.readableDatabase
        val selection = "$EMAIL = ? AND $PASS = ?"
        val selectionArgs = arrayOf(username, password)
        val cursor: Cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null)
        val count = cursor.count
        cursor.close()
        db.close()
        return count > 0
    }
}





