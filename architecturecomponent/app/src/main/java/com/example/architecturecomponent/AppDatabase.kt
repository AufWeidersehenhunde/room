package com.example.architecturecomponent

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Texts::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun txtDao(): TextsDao
}