package com.example.architecturesample.module

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.architecturesample.PersistenceStorage
import dagger.Provides

class RoomModule {

    @Provides
    fun roomDatabase(context: Context): PersistenceStorage {
        val dbName = "RoomDatabase"

        val db = Room.databaseBuilder(context, PersistenceStorage::class.java, dbName)
            .fallbackToDestructiveMigration()
            .build()

        if (!db.isOpen) {
            Log.e("RoomModule", "cannot open DB - you forgot to change the version")
        }
        return db
    }
}