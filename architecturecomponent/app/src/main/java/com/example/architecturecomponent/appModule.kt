package com.example.architecturecomponent

import androidx.room.Room
import com.example.architecturecomponent.Main.MainViewModel
import com.example.architecturecomponent.addscreen.AddViewModel
import com.example.architecturecomponent.dpandprovider.DBprovider
import com.example.architecturecomponent.dpandprovider.SomethingDb
import com.example.architecturecomponent.editscreen.EditViewModel
import com.example.architecturecomponent.homescreen.HomeViewModel
import com.example.architecturecomponent.repository.Repository
import com.github.terrakok.cicerone.Cicerone
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.Scope
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {
    val cicerone = Cicerone.create()
    single { cicerone.router }
    single { cicerone.getNavigatorHolder() }

    viewModel {HomeViewModel(get(),get())}
    viewModel {EditViewModel(get(),get())}
    viewModel {MainViewModel(get()) }
    viewModel { AddViewModel(get(),get()) }
    single {
        Room.databaseBuilder(
            androidApplication().applicationContext,
            DBprovider::class.java,
            "database"
        ).build()
    }
    single{ get<DBprovider>().somethingDao() }
    single { Repository (get())}
}

