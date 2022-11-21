package com.example.architecturecomponent.app

import android.app.Application
import com.example.architecturecomponent.appModule
import com.example.architecturecomponent.dpandprovider.DBprovider
import com.github.terrakok.cicerone.Cicerone
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(appModule)
        }
    }
}