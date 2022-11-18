package com.example.architecturecomponent.app

import android.app.Application
import com.example.architecturecomponent.dpandprovider.DBprovider

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        DBprovider.create(this)
    }
}