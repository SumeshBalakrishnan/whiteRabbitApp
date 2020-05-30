package com.whiterabbit.test.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.whiterabbit.test.model.Response


@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(users: List<Response>)

    @Query("SELECT * FROM person_info")
    fun getUsers(): List<Response>
}