package com.example.architecturecomponent.homescreen

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturecomponent.Screens
import com.example.architecturecomponent.dpandprovider.SomethingDb
import com.example.architecturecomponent.repository.Repository
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val router: Router,
    private val repo:Repository
): ViewModel() {


    fun routeToUuid(uuid: String){
        router.navigateTo(Screens.getEditTextFragment(uuid))
    }

    fun create(){
        router.newRootScreen(Screens.getEditFragment())
    }

    fun goToAdd(){
        router.navigateTo(Screens.getAddFragment())
    }

    fun observeAllSomething() = repo.getAllSomethingData()

    fun deleteSomethingModel(model: SomethingDb) {
        viewModelScope.launch {
           repo.deleteSomething(model)
        }
    }
}












