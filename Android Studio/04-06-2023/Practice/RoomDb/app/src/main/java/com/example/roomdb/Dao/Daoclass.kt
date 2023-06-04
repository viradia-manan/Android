package com.example.roomdb.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdb.Entity.User

@Dao
interface Daoclass
{
    @Insert
    fun insertdata(user:User?)

    @Query("select * from user")
    fun getUsers(): MutableList<User>
}