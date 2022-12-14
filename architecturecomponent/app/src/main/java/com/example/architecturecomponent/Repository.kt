package com.example.architecturecomponent

class Repository {
    private val somethingDao = DBprovider.instance.somethingDao()

    companion object{
        val instance = Repository()

    }
    fun getAllSomethingData() = somethingDao.getAllSomethingData()

    fun observeSomething(inputData:String) = somethingDao.observeSHTANI(inputData)

    suspend fun addSomething(model:SomethingDb) = somethingDao.addSomething(model)

    suspend fun deleteSomething(model:SomethingDb) = somethingDao.deleteSomething(model)

    suspend fun updateSomething(model:SomethingDb) = somethingDao.updateSomething(model)

}