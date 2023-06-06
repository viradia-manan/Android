package com.example.taskman

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)
{
    companion object
    {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "task_manager.db"
        val TABLE_TASKS = "tasks"
        val KEY_ID = "id"
        val KEY_NAME = "name"
        val KEY_DESCRIPTION = "description"
        val KEY_DATE = "date"
        val KEY_TIME = "time"
        val KEY_PRIORITY = "priority"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $TABLE_TASKS ($KEY_ID INTEGER PRIMARY KEY, $KEY_NAME TEXT, $KEY_DESCRIPTION TEXT, $KEY_DATE TEXT, $KEY_TIME TEXT, $KEY_PRIORITY INTEGER)"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_TASKS")
        onCreate(db)
    }

    fun addTask(task: Task): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(KEY_NAME, task.name)
            put(KEY_DESCRIPTION, task.description)
            put(KEY_DATE, task.date)
            put(KEY_TIME, task.time)
            put(KEY_PRIORITY,task.priority)
        }
        val id = db.insert(TABLE_TASKS, null, values)
        db.close()
        return id
    }

    fun updateTask(m: Task) {
        var db = writableDatabase
        var values = ContentValues()
        values.put(KEY_ID,m.id)
        values.put(KEY_NAME,m.name)
        values.put(KEY_DESCRIPTION,m.description)
        values.put(KEY_DATE,m.date)
        values.put(KEY_TIME,m.time)
        var updatequery = KEY_ID+" ="+m.id
        db.update(TABLE_TASKS,values,updatequery,null)
    }

    fun deleteTask(id: Int) {
        var db = writableDatabase
        var deletequery = KEY_ID+" ="+id
        db.delete(TABLE_TASKS,deletequery,null)
    }

    @SuppressLint("Range")
    fun getAllTasks(): MutableList<Task> {
        var db = readableDatabase
        var arraylist = ArrayList<Task>()
        var col = arrayOf(KEY_ID, KEY_NAME, KEY_DESCRIPTION, KEY_DATE, KEY_TIME, KEY_PRIORITY)
        var cursor: Cursor = db.query(TABLE_TASKS,col,null,null,null,null,null,null)

        while(cursor.moveToNext())
        {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var des = cursor.getString(2)
            var dt = cursor.getString(3)
            var t = cursor.getString(4)
            var p = cursor.getInt(5)

            var m = Task()
            m.id=id
            m.name=name
            m.description=des
            m.date=dt
            m.time=t
            m.priority=p


            arraylist.add(m)
        }

        return  arraylist

    }
}
