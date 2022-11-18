package com.example.architecturecomponent.repository

import com.example.architecturecomponent.dpandprovider.DBprovider
import com.example.architecturecomponent.dpandprovider.SomethingDb

class Repository {
    private val somethingDao = DBprovider.instance.somethingDao()

    companion object{
        val instance = Repository()

    }

    fun getAllSomethingData() = somethingDao.getAllSomethingData()

    suspend fun addSomething(model: SomethingDb) = somethingDao.addSomething(model)

    suspend fun deleteSomething(model: SomethingDb) = somethingDao.deleteSomething(model)

    suspend fun updateSomething(model: SomethingDb) = somethingDao.updateSomething(model)


}