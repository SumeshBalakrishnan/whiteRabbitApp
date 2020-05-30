package com.whiterabbit.test.db

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.whiterabbit.test.model.Response

@Dao
interface PersonDao {
    /**
     * Insert a person data into the table
     * @return row ID for newly inserted data
     */
    @Insert
    fun insert(person: Response?): Long

    /**
     * select all person
     * @return A [Cursor] of all person in the table
     */
    @Query("SELECT * FROM person_info")
    fun findAll(): Cursor?
}