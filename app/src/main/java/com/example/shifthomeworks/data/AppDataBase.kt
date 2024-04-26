package com.example.shifthomeworks.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ContactDbModel::class],
    version = 3,
    exportSchema = false
)
abstract class AppDataBase  : RoomDatabase(){

    abstract fun contactDao():ContactDao
    companion object {

        private var INSTANCE: AppDataBase? = null
        private val LOCK = Any()
        private const val DB_NAME = "contact_item.db"

        fun getInstance(application: Application): AppDataBase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
            }
            val db = Room.databaseBuilder(
                application,
                AppDataBase::class.java,
                DB_NAME
            )
//                .allowMainThreadQueries()
                .build()
            INSTANCE = db
            return db
        }
    }
}