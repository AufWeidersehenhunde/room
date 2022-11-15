package com.example.architecturecomponent

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "txt")
data class Texts(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "first_text") val firstText: String?,
    @ColumnInfo(name = "last_text") val lastText: String?
)