package com.example.architecturesample

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [

    ],
    version = 1, exportSchema = false
)
abstract class PersistenceStorage : RoomDatabase()