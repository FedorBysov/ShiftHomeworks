package com.example.shifthomeworks.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "storage_items")
data class ContactDbModel(

    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,

    val name:String=" ",

    val number: String
)