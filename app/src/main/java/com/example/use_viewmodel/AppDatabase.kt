package com.example.use_viewmodel

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HomeScreenDataClass::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun homeDao(): HomeDao
}