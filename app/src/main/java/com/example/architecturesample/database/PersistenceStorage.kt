package com.example.architecturesample.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Profile::class
    ],
    version = 1, exportSchema = false
)
abstract class PersistenceStorage : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
}