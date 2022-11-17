package com.example.architecturecomponent.firstscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturecomponent.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BlankViewModel : ViewModel() {
    private var _planetextTwo = MutableStateFlow<String?>(null)
    private var _planetext = MutableStateFlow<String?>(null)
    var planetext: StateFlow<String?> = _planetext
    var planetextTwo:StateFlow<String?> = _planetextTwo



    fun observeAllSomething() = Repository.instance.getAllSomethingData()
    fun observeSHTANI(inputData: String) {
        Repository.instance.observeSomething(inputData)
        val model = SomethingDb(firstText = String(), lastText = String())
        _planetext.value = model.firstText
        _planetextTwo.value = model.lastText
    }
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