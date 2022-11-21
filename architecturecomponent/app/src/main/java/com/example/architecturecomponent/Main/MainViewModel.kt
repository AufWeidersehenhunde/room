package com.example.architecturecomponent.Main

import androidx.lifecycle.ViewModel
import com.example.architecturecomponent.Screens
import com.github.terrakok.cicerone.Router

class MainViewModel(
    private val router: Router
) : ViewModel() {

    fun create() {
        router.newRootScreen(Screens.getHomeFragment())
    }

}