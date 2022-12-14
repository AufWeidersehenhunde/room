package com.example.architecturecomponent

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SomethingDb::class], version = 1)
abstract class DBprovider : RoomDatabase() {
    companion object{
        lateinit var instance: DBprovider
        fun create (context: Context){
            instance = Room.databaseBuilder(context, DBprovider::class.java, "database").build()
        }
    }
    abstract fun somethingDao():TextsDao
}