package com.example.architecturecomponent.addscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturecomponent.Screens
import com.example.architecturecomponent.dpandprovider.SomethingDb
import com.example.architecturecomponent.repository.Repository
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.launch

class AddViewModel(
    private val router: Router,
    private val repo:Repository
): ViewModel() {
    fun goToBack(){
        router.backTo(Screens.getHomeFragment())
    }
    fun addStaticSomethingData(firstText: String, lastText: String) {
        viewModelScope.launch {
            val model = SomethingDb(firstText = firstText, lastText = lastText)
            repo.addSomething(model)
        }
    }
}