package com.example.architecturecomponent.addscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturecomponent.dpandprovider.SomethingDb
import com.example.architecturecomponent.repository.Repository
import kotlinx.coroutines.launch

class AddViewModel:ViewModel() {
    fun addStaticSomethingData(firstText: String, lastText: String) {
        viewModelScope.launch {
            val model = SomethingDb(firstText = firstText, lastText = lastText)
            Repository.instance.addSomething(model)
        }
    }
}