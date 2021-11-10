package com.pihda.manages.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EmployeeDB::class], version = 1, exportSchema = false)
abstract class EmployeeDB : RoomDatabase() {

    abstract val sleepDatabaseDao: EmployeeDBDao

    companion object {

        @Volatile
        private var INSTANCE: EmployeeDB? = null

        fun getInstance(context: Context): EmployeeDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        EmployeeDB::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}