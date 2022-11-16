package com.example.architecturecomponent.app

import android.app.Application
import androidx.room.Database
import com.example.architecturecomponent.DBprovider
import com.example.architecturecomponent.SomethingDb

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        DBprovider.create(this)
    }
}