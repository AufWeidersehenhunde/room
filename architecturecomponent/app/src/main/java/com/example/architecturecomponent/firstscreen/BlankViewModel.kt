package com.example.architecturecomponent.firstscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturecomponent.*
import kotlinx.coroutines.launch

class BlankViewModel : ViewModel() {

    fun observeAllSomething() = Repository.instance.getAllSomethingData()

    fun addStaticSomethingData(firstText: String, lastText: String) {

        viewModelScope.launch {
            val model = SomethingDb(firstText = firstText, lastText = lastText)
            Repository.instance.addSomething(model)
        }
    }

    fun updateSomethingModel(firstText: String, lastText: String) {
        viewModelScope.launch {
            val model = SomethingDb(firstText = firstText, lastText = lastText)
            Repository.instance.addSomething(model)
        }
    }


    fun deleteSomethingModel(model: SomethingDb) {
        viewModelScope.launch {
            Repository.instance.deleteSomething(model)
        }
    }

}