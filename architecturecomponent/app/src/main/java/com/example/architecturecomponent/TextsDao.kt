package com.example.architecturecomponent

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TextsDao {
    @Query("SELECT * FROM txt")
    fun getAll():LiveData<List<Texts>>

    @Query("SELECT * FROM txt WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Texts>

    @Query("SELECT * FROM txt WHERE first_text LIKE :first AND " +
            "last_text LIKE :last LIMIT 66666")
    fun findByName(first: String, last: String): Texts

    @Insert
    fun insertAll(vararg txts: Texts)

    @Delete
    fun delete(txt: Texts)
}