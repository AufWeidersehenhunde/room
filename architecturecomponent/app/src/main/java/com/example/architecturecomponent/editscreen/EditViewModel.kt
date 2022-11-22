package com.example.architecturecomponent.editscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturecomponent.Screens
import com.example.architecturecomponent.dpandprovider.SomethingDb
import com.example.architecturecomponent.repository.Repository
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class EditViewModel(
    private val router: Router,
    private val repo: Repository
) : ViewModel() {

    private val _model =
        MutableStateFlow<SomethingDb>(SomethingDb(firstText = "test", lastText = "123123"))
    val model: MutableStateFlow<SomethingDb> = _model


    fun goHome() {
        router.navigateTo(Screens.getHomeFragment())
    }

    fun getIt(uuid: String) {
        viewModelScope.launch {
            _model.value = repo.getItemForId(uuid)
        }
    }

    fun updateSomethingModel(uuid: String, firstText: String, lastText: String) {
        viewModelScope.launch {
            val model = SomethingDb(uuid = uuid, firstText = firstText, lastText = lastText)
            repo.updateSomething(model)
        }
    }

}