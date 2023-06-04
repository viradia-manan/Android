package com.example.roomdb.Database

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.roomdb.Dao.Daoclass
import com.example.roomdb.Entity.User


@Database(entities = [User::class], version = 1)
abstract class MyDb :RoomDatabase()
{

    abstract fun daoClass(): Daoclass

}