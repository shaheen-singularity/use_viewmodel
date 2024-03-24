package com.example.use_viewmodel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test")
data class HomeScreenDataClass(
    @PrimaryKey(autoGenerate = true)
    var name:String = ""
)
