package com.example.use_viewmodel

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface HomeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertName(homeScreenDataClass: HomeScreenDataClass)

    @Query("SELECT * FROM test")
    suspend fun getAllUsers(): List<HomeScreenDataClass>
}