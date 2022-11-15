package com.example.architecturecomponent.firstscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturecomponent.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BlankViewModel : ViewModel() {
    private val _list = MutableStateFlow<MutableList<Task>?>(null)
    val list: MutableStateFlow<MutableList<Task>?> = _list
    init {
        equals()
    }

    fun equals() {
        viewModelScope.launch {
            while (true) {
                val element0 = Task("5", "5")
                val list = _list.value?.toMutableList()
                list?.add(element0)
                _list.value = list
            }
        }
    }


    fun deleteElement(it: Task) {
        val list = _list.value!!.toMutableList()
        list.remove(it)
        _list.value = list
    }
}