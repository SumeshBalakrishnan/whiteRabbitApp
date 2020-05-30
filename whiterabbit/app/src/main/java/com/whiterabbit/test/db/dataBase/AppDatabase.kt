package com.whiterabbit.test.db.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.whiterabbit.test.db.converter.DateTypeConverter
import com.whiterabbit.test.db.converter.ListConverter
import com.whiterabbit.test.db.dao.UserDao
import com.whiterabbit.test.model.Response

@Database(entities = [Response::class], version = 1)
@TypeConverters(DateTypeConverter::class, ListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "myDB"
                    ).build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase() {
            INSTANCE = null
        }
    }
}