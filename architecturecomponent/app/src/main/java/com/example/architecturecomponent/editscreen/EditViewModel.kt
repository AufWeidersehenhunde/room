package com.example.architecturecomponent.editscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturecomponent.dpandprovider.SomethingDb
import com.example.architecturecomponent.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class EditViewModel:ViewModel() {



    fun updateSomethingModel(uuid: String,firstText: String, lastText: String) {
        viewModelScope.launch {
            val model = SomethingDb(uuid = uuid,firstText = firstText, lastText = lastText)
            Repository.instance.updateSomething(model)
        }
    }

}