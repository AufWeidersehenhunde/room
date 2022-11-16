package com.example.architecturecomponent

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TextsDao {

    @Query("SELECT * FROM txt")
    fun getAllSomethingData():LiveData<List<SomethingDb>>

    @Insert
    suspend fun addSomething(model:SomethingDb)

    @Delete
    suspend fun deleteSomething(model: SomethingDb)


    @Update
    suspend fun updateSomething(model: SomethingDb)


}