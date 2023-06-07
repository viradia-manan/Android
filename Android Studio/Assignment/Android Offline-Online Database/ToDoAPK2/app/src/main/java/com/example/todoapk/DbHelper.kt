package com.example.todoapk

    import android.content.ContentValues
    import android.content.Context
    import android.database.Cursor
    import android.database.sqlite.SQLiteDatabase
    import android.database.sqlite.SQLiteOpenHelper

    class DbHelper(var context: Context):SQLiteOpenHelper(context,dbname,null,dbversion) {

        companion object {
            var dbname = "user.db"
            var tablename = "info"
            var id = "id"
            var title = "title"
            var task = "task"
            var dbversion = 1
        }

        override fun onCreate(db: SQLiteDatabase?) {
            var query =
                "CREATE TABLE " + tablename + "(" + id + " INTEGER PRIMARY KEY," + title + " TEXT," + task + " TEXT" + ")"
            db!!.execSQL(query)

        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            var upquery = "DROP TABLE IF EXISTS " + tablename
            db!!.execSQL(upquery)
            onCreate(db)
        }

        fun insert(m: Model): Long {
            var db = writableDatabase
            var value = ContentValues()
            value.put(task, m.task)
            value.put(title,m.title)
            var Id = db.insert(tablename, id, value)
            return Id
        }

        fun view(): ArrayList<Model> {
            var db = readableDatabase
            var arraylist = ArrayList<Model>()
            var col = arrayOf(id, title, task)
            var cursor: Cursor = db.query(tablename, col, null, null, null, null, null, null)

            while (cursor.moveToNext()) {
                var id = cursor.getInt(0)
                var title = cursor.getString(1)
                var task = cursor.getString(2)

                var m = Model()
                m.id = id
                m.title=title
                m.task = task

                arraylist.add(m)
            }
            return arraylist
        }

        fun delete(Id: Int) {
            var db = writableDatabase
            var deletequery = id + " =" + Id
            db.delete(tablename, deletequery, null)

        }

        fun update(m:Model)
        {
            var db = writableDatabase
            var values = ContentValues()
            values.put(id,m.id)
            values.put(title,m.title)
            values.put(task,m.task)
            var updatequery = id+" ="+m.id
            db.update(tablename,values,updatequery,null)
        }
    }