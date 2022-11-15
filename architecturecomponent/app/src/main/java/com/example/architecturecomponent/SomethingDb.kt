package com.example.architecturecomponent

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "txt")
data class SomethingDb(
    @PrimaryKey var uuid:String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "first_text") val firstText: String?,
    @ColumnInfo(name = "last_text") val lastText: String?
):java.io.Serializable {
}