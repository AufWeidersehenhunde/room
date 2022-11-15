package com.example.architecturecomponent

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
@Database(entities = [SomethingDb::class], version = 1)
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
        val txtDao = db.txtDao()
        val txts: LiveData<List<Texts>> = txtDao.getAll()
    }
}