package com.example.architecturecomponent.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturecomponent.dpandprovider.SomethingDb
import com.example.architecturecomponent.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel:ViewModel() {


    fun observeAllSomething() = Repository.instance.getAllSomethingData()

    fun deleteSomethingModel(model: SomethingDb) {
        viewModelScope.launch {
            Repository.instance.deleteSomething(model)
        }
    }
}